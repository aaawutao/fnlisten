$(document).ready(function () {
    new jPlayerPlaylist({
            jPlayer: "#jplayer_N",
            cssSelectorAncestor: "#jp_container_N"
        }, [],
        {
            playlistOptions: {
                enableRemoveControls: true,
                autoPlay: false
            },
            swfPath: "js/jPlayer",
            supplied: "webmv, ogv, m4v, oga, mp3",
            useStateClassSkin: true,
            autoBlur: false,
            smoothPlayBar: true,
            keyEnabled: true,
            audioFullScreen: false
        });

});
