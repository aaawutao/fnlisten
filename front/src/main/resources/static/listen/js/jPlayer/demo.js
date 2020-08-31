$(document).ready(function () {
 var latest = [
    { title: "The wheel of fortune", artist: "Yang Bingyin", mp3: "http://music.163.com/song/media/outer/url?id=476515941.mp3", poster: "http://p1.music.126.net/4xHOkSVWH-n6p5pB3Jf0yQ==/109951162922204274.jpg?param=130y130" },
    { title: "you are my king", artist: "梶浦由記", mp3: "http://music.163.com/song/media/outer/url?id=22731459.mp3", poster: "http://p1.music.126.net/Xy8iaLLLVT21Mr9wDDJBNQ==/792747883650465.jpg?param=130y130" },
    { title: "初恋的小美好", artist: "Sunny是个小太阳", mp3: "http://music.163.com/song/media/outer/url?id=529823229.mp3", poster: "http://p1.music.126.net/7DvTdaOADAw7KiKVkcMcag==/109951163105691071.jpg?param=130y130" },
    { title: "Lilac", artist: "MANYO", mp3: "http://music.163.com/song/media/outer/url?id=28466087.mp3", poster: "http://p1.music.126.net/scAe3f-GkQvo2h91Gpb0Bg==/1729531800492601.jpg?param=130y130" },
    { title: "一人静", artist: "姫神", mp3: "http://music.163.com/song/media/outer/url?id=25917069.mp3", poster: "http://p1.music.126.net/FnElEjsh00iuHWtHXrcY9g==/5638295627307829.jpg?param=130y130" },
    { title: "Through My Blood", artist: "Aimer", mp3: "http://music.163.com/song/media/outer/url?id=409872505.mp3", poster: "http://p1.music.126.net/45Qck88DR58FGgdHdDqfBw==/18181524277717113.jpg?param=130y130" },
    { title: "Too Late To Say", artist: "Sayulee", mp3: "http://music.163.com/song/media/outer/url?id=486194219.mp3", poster: "http://p1.music.126.net/Oa_1_y0a8NCmxB1zYKAFpw==/19187577416516096.jpg?param=130y130" },
    { title: "琥珀色の海へ", artist: "40㍍P", mp3: "http://music.163.com/song/media/outer/url?id=836411.mp3", poster: "http://p1.music.126.net/80iknoJfJHHLUSjz_EiSDw==/18736777650906624.jpg?param=130y130" },
    { title: "からくりピエロ (instrumental)", artist: "MUSIRISCA", mp3: "http://music.163.com/song/media/outer/url?id=33004714.mp3", poster: "http://p1.music.126.net/9kAx7AtyLbLop_XhJy3y5w==/3415083117091737.jpg?param=130y130" },
    { title: "M04", artist: "梶浦由記", mp3: "http://music.163.com/song/media/outer/url?id=591901.mp3", poster: "http://p1.music.126.net/Rm8d72Gom9BZcDOmPBPPkA==/2923601420858492.jpg?param=130y130" },
    { title: "M35", artist: "梶浦由記", mp3: "http://music.163.com/song/media/outer/url?id=28267707.mp3", poster: "http://p1.music.126.net/a-fgC2MhmKzNNOrmrQ_CMA==/5972547162126209.jpg?param=130y130" },
    { title: "哈尔的移动城堡", artist: "久石譲", mp3: "http://music.163.com/song/media/outer/url?id=481390254.mp3", poster: "http://p1.music.126.net/BmJ2bUsQwinDU2KiDsKkEQ==/5998935441331080.jpg?param=130y130" },
    { title: "流れ星 ", artist: "久石譲", mp3: "http://music.163.com/song/media/outer/url?id=26902975.mp3", poster: "http://p1.music.126.net/cJrHNkktHNG62uKdYvGahg==/4453022092508799.jpg?param=130y130" },
    { title: "Memories", artist: "Within Temptation", mp3: "http://music.163.com/song/media/outer/url?id=407002778.mp3", poster: "http://p1.music.126.net/cqNHhKOTcfkwIM8_YIaT1w==/3275445150564990.jpg?param=130y130" },
    { title: "それがあなたの幸せとしても", artist: "rairu", mp3: "http://music.163.com/song/media/outer/url?id=41654821.mp3", poster: "http://p1.music.126.net/SpovasHBud2A1qXXADXsBg==/109951163167455610.jpg?param=130y130" },
    { title: "Angel", artist: "阿桑", mp3: "http://music.163.com/song/media/outer/url?id=205276.mp3", poster: "http://p1.music.126.net/8cSVJulJa2tiLydRxyXuTg==/109951162938339077.jpg?param=130y130" },
    { title: "兰若词", artist: "刘亦菲", mp3: "http://music.163.com/song/media/outer/url?id=255739.mp3", poster: "http://p1.music.126.net/L4Sah2hA5QYBPUnpjjUQ0Q==/26388279081790.jpg?param=130y130" },
    { title: "Pieces Of My Words-言の花-", artist: "刘亦菲", mp3: "http://music.163.com/song/media/outer/url?id=255805.mp3", poster: "http://p1.music.126.net/L4Sah2hA5QYBPUnpjjUQ0Q==/26388279081790.jpg?param=130y130" }
  ];
  
  var myPlaylist = new jPlayerPlaylist({
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
 
  $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer, function () {//$(document).on('click','要选择的元素',function(){})  on方法包含很多事件，点击，双击等等事件。
    $('.musicbar').removeClass('animate'); //look this class and remove it
    $('.jp-play-me').removeClass('active');
    $('.jp-play-me').parent('li').removeClass('active');
  }); 

  $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer, function () {
    $('.musicbar').addClass('animate');// when the player add a animate
  });
  $("#before,#after").addClass("set_imd");

  $(document).on('click', '.jp-play-me', function (e) {
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');//closest() 方法获得匹配选择器的第一个祖先元素，从当前元素开始沿 DOM 树向上。
    $('.jp-play-me').not($this).removeClass('active');
    $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');

    $this.toggleClass('active');
    $this.parent('li').toggleClass('active');
    if (!$this.hasClass('active')) {
      myPlaylist.pause();
    } else {
	 //添加
      var k = $(this).parent("li").index();

      $(".poster-img").attr("src", latest[k].poster);//此方法返回一个函数改变src   $('a.cover1').html('<img src="' + latest[k].poster );
      $(".musicbar").addClass("animate").index();
      myPlaylist.add({
        title: latest[k].title,
        artist: latest[k].artist,
        mp3: latest[k].mp3,
        poster: latest[k].poster
      });
      myPlaylist.play(-1);
    }
  });
});
