/**
 * lrz3
 * https://github.com/think2011/localResizeIMG3
 * @author think2011
 */
;
(function () {
    window.URL = window.URL || window.webkitURL;
    var userAgent = navigator.userAgent;

    /**
     * 瀹㈡埛绔帇缂╁浘鐗�
     * @param file
     * @param [options]
     * @param callback
     * @constructor
     */
    function Lrz(file, options, callback) {
        this.file = file;
        this.callback = callback;
        this.defaults = {quality: 7};

        // 閫傚簲浼犲叆鐨勫弬鏁�
        if (callback) {
            for (var p in options) {
                this.defaults[p] = options[p];
            }
            if (this.defaults.quality > 10) this.defaults.quality = 10;
        } else {
            this.callback = options;
        }

        this.results = {
            blob: null,
            origin: null,
            base64: null
        };

        this.init();
    }

    Lrz.prototype = {
        constructor: Lrz,

        /**
         * 鍒濆鍖�
         */
        init: function () {
            var that = this;

            that.create(that.file, that.callback);
        },

        /**
         * 鐢熸垚base64
         * @param file
         * @param callback
         */
        create: function (file, callback) {
            var that = this,
                img = new Image(),
                results = that.results,
                blob = URL.createObjectURL(file);

            img.onload = function () {
                // 鑾峰緱鍥剧墖缂╂斁灏哄
                var resize = that.resize(this);

                // 鍒濆鍖朿anva
                var canvas = document.createElement('canvas'), ctx;
                canvas.width = resize.w;
                canvas.height = resize.h;
                ctx = canvas.getContext('2d');

                // 璋冩暣姝ｇ‘鐨勬媿鎽勬柟鍚�
                var mpImg = new MegaPixImage(img);
                EXIF.getData(img, function () {
                    mpImg.render(canvas, {
                        width: canvas.width,
                        height: canvas.height,
                        orientation: EXIF.getTag(this, "Orientation")
                    });

                    // 璁剧疆鐧借壊鑳屾櫙
                    ctx.fillStyle = '#fff';
                    ctx.fillRect(0, 0, canvas.width, canvas.height);
                    
                    // 鐢熸垚缁撴灉
                    results.blob = blob;
                    results.origin = file;

                    ctx.drawImage(img,0, 0, resize.w, resize.h);

                    // 鍏煎 Android
                    if (/Android/i.test(userAgent)) {
                        try {
                            var encoder = new JPEGEncoder();

                            results.base64 = encoder.encode(ctx.getImageData(0, 0, canvas.width, canvas.height), that.defaults.quality * 100);
                        } catch (_error) {
                            alert('鏈紩鐢╩obile琛ヤ竵锛屾棤娉曠敓鎴愬浘鐗囥€�');
                        }
                    }

                    // 鍏朵粬鎯呭喌&IOS
                    else {
                        results.base64 = canvas.toDataURL('image/jpeg', that.defaults.quality);
                    }

                    // 鎵ц鍥炶皟
                    callback(results);
                });
            };

            img.src = blob;
        },

        /**
         * 鑾峰緱鍥剧墖鐨勭缉鏀惧昂瀵�
         * @param img
         * @returns {{w: (Number), h: (Number)}}
         */
        resize: function (img) {
            var w = this.defaults.width,
                h = this.defaults.height,
                scale = img.width / img.height,
                ret = {w: img.width, h: img.height};

            if (w & h) {
                ret.w = w;
                ret.h = h;
            }
            else if (w) {
                ret.w = w;
                ret.h = Math.ceil(w / scale);
            }

            else if (h) {
                ret.w = Math.ceil(h * scale);
                ret.h = h;
            }

            return ret;
        }
    };

    // 鏆撮湶鎺ュ彛
    window.lrz = function (file, options, callback) {
        return new Lrz(file, options, callback);
    };
})()