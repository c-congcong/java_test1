var debug = false;
var textNvdaDay = '天',
    textNvdaHour = '小时',
    textNvdaMin = '分钟',
    textNvdaSec = '秒';

/*
 * jQuery Countdown Plugin
 */
;
(function($, window, undefined) {

    // Create the defaults once
    var pluginName = 'olympicCountdown',
        document = window.document,
        defaults = {
            getTime: "",
            // clicktag: "",
            renderCufon: false,
            cufonShadow: '1px 3px rgba(0, 0, 0, .4)'
        };

    // The actual plugin constructor
    function Plugin(element, options) {
        this.element = element;
        this.domElementId = "#" + this.element.id;

        this.options = $.extend({}, defaults, options);

        this._defaults = defaults;
        this._name = pluginName;

        if ($(this.element).hasClass('white')) this.options.cufonShadow = '0px 0px rgba(0, 0, 0, 0)';

        this.init();
    }

    Plugin.prototype.init = function() {

        var plugin = this;

        this.time = 0;
        this.countdownTime = 0;
        this.dateObj = new Date();

        // load the timestamps via PHP
        $.ajax({
            type: "GET",
            url: this.options.getTime,
            dataType: "script",
            context: plugin,
            error: function(xmlhttp, error_msg) {
                log("error" + error_msg);
            },
            success: function(data) {
                plugin.setup(data);
            }
        });

        $(this.element).click(function() {
            plugin.redirect();
        });
    }

    Plugin.prototype.setup = function(data) {
        this.time = parseInt(now) * 1000;
        this.countdownTime = parseInt(olympics) * 1000;
        if (debug == true)
            this.countdownTime = (parseInt(now) + 10) * 1000;
        //log(this.time,this.countdownTime);

        $(this.element).show();

        if (this.countdownTime < this.time) {
            this.showRealTime();
        } else {
            this.showCountdown();
        }
    }

    // Plugin.prototype.redirect = function() {
    //     window.open(this.options.clicktag);
    // }

    Plugin.prototype.showRealTime = function() {

        var plugin = this;
        clearInterval(plugin.interval);

        setTimeout(function() {
            if (plugin.options.renderCufon) Cufon.replace(plugin.domElementId + ' .cd-real-copy.cufonEn');
            $(plugin.element).removeClass("black-countdown white-countdown");

            $(plugin.domElementId + ' .cd-realtime').show();
            $(plugin.domElementId + ' .cd-countdown').hide();

            $('#js-nvda-countdown-title').attr('alt','北京2022年冬奥会');

            plugin.interval = setInterval(function() { plugin.clockTick(); }, 1000);


            plugin.time -= 1000;
            plugin.clockTick();
        }, 3000);

    }

    Plugin.prototype.showCountdown = function() {
        var plugin = this;
        if (this.options.renderCufon) Cufon.replace(this.domElementId + ' .cd-labels .cufonEn', { textShadow: this.options.cufonShadow });
        if (this.options.renderCufon) Cufon.replace(this.domElementId + ' .cd-copy.cufonEn');

        if ($(this.element).hasClass('black')) $(this.element).addClass("black-countdown");
        if ($(this.element).hasClass('white')) $(this.element).addClass("white-countdown");

        $(this.domElementId + ' .cd-countdown').show();
        $(this.domElementId + ' .cd-realtime').hide();
        $('#js-nvda-countdown-title').attr('alt','距离北京冬奥会开幕还有');

        clearInterval(this.interval);
        this.interval = setInterval(function() { plugin.countdownTick(); }, 1000);
        this.time -= 1000;
        this.countdownTick();
    }

    /**
     * display current time
     */
    Plugin.prototype.clockTick = function() {

        //this.time += 1000;

        //this.dateObj.setTime(this.time);
        this.dateObj = new Date();

        var s = this.dateObj.getSeconds();
        var m = this.dateObj.getMinutes();
        var h = this.dateObj.getHours();

        s = s < 10 ? "0" + s : s;
        m = m < 10 ? "0" + m : m;
        h = h < 10 ? "0" + h : h;

        textNvdaHour = h < 2 ? "小时" : '小时';
        textNvdaMin = m < 2 ? "分钟" : '分钟';
        textNvdaSec = s < 2 ? "秒" : '秒';

        $(this.domElementId + ' .realhValue').text(h);
        $(this.domElementId + ' .realmValue').text(m);
        $(this.domElementId + ' .realsValue').text(s);

        $('#js-nvda-countdown-timer').attr('alt', textNvdaHour + " " + h + " " + textNvdaMin + " " + m + " " + textNvdaSec + " " + s);

        if (this.options.renderCufon) Cufon.replace(this.domElementId + ' .cd-real-values .cufonEn', { textShadow: this.options.cufonShadow });
    }

    /**
     * display countdown  倒计时
     */
    Plugin.prototype.countdownTick = function() {

        this.time += 1000;

        var timestamp = this.countdownTime - this.time;

        if (timestamp < 0) { // time is reached
            this.showRealTime();
            return;
        }

        timestamp = (timestamp / 1000);
        var s = Math.floor(timestamp % 60);
        timestamp = (timestamp / 60);
        var m = Math.floor(timestamp % 60);
        timestamp = (timestamp / 60);
        var h = Math.floor(timestamp % 24);
        timestamp = (timestamp / 24);
        //var d = Math.floor(timestamp%365);
        var d = Math.floor(timestamp);

        s = s < 10 ? "0" + s : s;
        m = m < 10 ? "0" + m : m;
        h = h < 10 ? "0" + h : h;
        d = d < 10 ? "0" + d : d;

        textNvdaDay = d < 2 ? "天" : '天';
        textNvdaHour = h < 2 ? "小时" : '小时';
        textNvdaMin = m < 2 ? "分钟" : '分钟';
        textNvdaSec = s < 2 ? "秒" : '秒';

        $(this.domElementId + ' .dLabel').text(textNvdaDay);

        $(this.domElementId + ' .dValue').text(d);
        $(this.domElementId + ' .hValue').text(h);
        $(this.domElementId + ' .mValue').text(m);
        $(this.domElementId + ' .sValue').text(s);

        $('#js-nvda-countdown-timer').attr('alt', textNvdaDay + " " + d + " " + textNvdaHour + " " + h + " " + textNvdaMin + " " + m + " " + textNvdaSec + " " + s);

        if (this.options.renderCufon) Cufon.replace(this.domElementId + ' .cd-values .cufonEn', { textShadow: this.options.cufonShadow });
    }

    // A really lightweight plugin wrapper around the constructor,
    // preventing against multiple instantiations
    $.fn[pluginName] = function(options) {
        return this.each(function() {
            if (!$.data(this, 'plugin_' + pluginName)) {
                $.data(this, 'plugin_' + pluginName, new Plugin(this, options));
            }
        });
    }

}(jQuery, window));