$(function () {
    // $.noConflict();
    jQuery('#example3').beforeAfter_slider(
        {
            left: 1,
            top: 1,
            width: 570,
            height: 264,
            start_from: 'left',
            start_pos: 447,
            follow: false,
            //播放列表控制事件
            timer: 15000
        }
    )
});