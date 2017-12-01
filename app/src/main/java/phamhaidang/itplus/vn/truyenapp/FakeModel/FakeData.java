package phamhaidang.itplus.vn.truyenapp.FakeModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class FakeData {
    public static ArrayList<Manga> mangalist = new ArrayList<>();
    public static TreeSet<Category> categories = new TreeSet<>();
    public static ArrayList<Chap> chaps = new ArrayList<>();
    public static ArrayList<Author> authors = new ArrayList<>();
    private static HashMap<Integer, Integer> author_manga = new HashMap<>();
    public static ArrayList<String> img_lst = new ArrayList<>();

    private static java.sql.Date Fakedate(int Date, int Month, int Year) {
        return new java.sql.Date(Year, Month, Date);
    }

    static {
        //FAKE CHAP
        img_lst.add("http://storage.fshare.vn/Test-vechai/1509121579-038.png");
        img_lst.add("http://storage.fshare.vn/Test-vechai/1509121579-039.png");
        img_lst.add("http://storage.fshare.vn/Test-vechai/1509121579-040.png");
        img_lst.add("http://storage.fshare.vn/Test-vechai/1509121579-041.png");
        img_lst.add("http://storage.fshare.vn/Test-vechai/1509121579-042.png");
        img_lst.add("http://storage.fshare.vn/Test-vechai/1509121579-043.png");
        img_lst.add("http://storage.fshare.vn/Test-vechai/1509121579-044.png");
        img_lst.add("http://storage.fshare.vn/Test-vechai/1509121579-045.png");
        chaps.add(new Chap(0, 0, img_lst));
        chaps.add(new Chap(0, 1, img_lst));
        chaps.add(new Chap(0, 2, img_lst));
        chaps.add(new Chap(0, 3, img_lst));
        chaps.add(new Chap(0, 4, img_lst));

        //FAKE CATEGORY
        String[] catetories = {"Shounen", "Fantasy", "Comedy", "Adventure", "Action"};
        mangalist.add(new Manga("Thất Tông Tội",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "\"Thất đại ác nhân\", một nhóm chiến binh có tham vọng lật đổ vương quốc Britannia, được cho là đã bị tiêu diệt bởi các \"hiệp sĩ thánh chiến\" mặc dù vẫn còn 1 số người cho rằng họ vẫn còn sống. 10 năm sau, Các hiệp sĩ thánh chiến đã làm 1 cuộc đảo chính và khống chế đức vua, họ trở thành người cai trị độc tài mới của vương quốc. Elizabeth, con gái duy nhất của nhà vua, đã lên đường tìm \"thất đại ác nhân\" để nhờ họ tái chiếm lại vương quốc. Công chúa có thành công trong việc tìm kiếm \"thất đại ác nhân\", các \"hiệp sĩ thánh chiến\" sẽ làm gì để ngăn chăn cô? xem các chap truyện sau sẽ rõ.",
                        Fakedate(1, 1, 1992), 0, 1.2, "http://cdn.truyentranh.net/upload/image/comic/20150318/nanatsu-no-taizai-58cf8efc8ce9e-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"Manga", "Supernatural", "Shounen", "Martial Arts", "Action"};
        mangalist.add(new Manga("Dragon Ball Super",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Dragon Ball Super là một phần tiếp theo của Dragon Ball Z có cả truyện lẫn phim\n" +
                        "Thiết kế cốt truyện, khung hình và nhân vật đều được tạo ra bởi Akira Toriyama. Bộ phim sẽ được làm bởi Toie Anime còn manga sẽ được vẽ bởi tác giả DBH - Toyotarou\n" +
                        "Câu chuyện của Dragon Ball Super diễn ra ngay sau khi chiến đấu với Ma Nhân Bư, cuộc sống ở trái đất lại được hòa bình thêm 1 lần nữa. Sau đó vì nhà gần như hết tiền để chi tiêu Chichi tiền ra lệnh cho Goku phải đi kiếm tiền, và không được phép luyện tập trong thời gian này!! Videl sắp trở thành chị dâu của Goten nên Goten đã đặt ra một cuộc hành trình cùng với TRunks để tìm cho Videl một món quà!",
                        Fakedate(2, 2, 1991), 0, 2.3, "http://cdn.truyentranh.net/upload/image/comic/20151229/dragon-ball-super-thumbnail-176x264.jpg"
                )
        );

        catetories = new String[]{"Shounen", "Mystery", "Comedy", "Adventure", "Action"};
        mangalist.add(new Manga("Phù thủy không phép thuật",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Aster và Yuno là hai đứa trẻ bị bỏ rơi ở nhà thờ và cùng nhau lớn lên tại đó. Khi còn nhỏ, chúng đã hứa với nhau xem ai sẽ trở thành Ma pháp vương tiếp theo. Khi cả hai lớn lên, mọi sô chuyện đã thay đổi. Yuno là thiên tài ma pháp với sức mạnh tuyệt đỉnh trong khi Aster lại không thể sử dụng ma pháp và cố gắng bù đắp bằng thể lực. Thế nhưng, sức mạnh của kẻ bị bỏ rơi Aster không phải chỉ như thế...",
                        Fakedate(2, 3, 1993), 0, 2.4, "http://cdn.truyentranh.net/upload/image/comic/20150422/black-clover-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"School Life", "Romance", "Harem", "Comedy"};
        mangalist.add(new Manga("Bokutachi wa benkyou ga dekinai",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Sẽ ra sao nếu bạn phải làm gia sư văn học cho một thiên tài toán và toán cho một đứa thiên tài văn học. Hãy trải nghiệm cùng với nhân vật chính của chúng ta, một học sinh tuy chẳng phải thiên tài nhưng phải nhận trách nhiệm gian lao nàyemo",
                        Fakedate(3, 8, 1993), 0, 2.5, "http://cdn.truyentranh.net/upload/image/comic/20170215/Bokutachi-wa-benkyou-ga-dekinai-58a45fc097911-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"Manga"};
        mangalist.add(new Manga("Death Note: Death Eraser",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Tiền thân của Death Note, được xuất bản trong Weekly Shonen Jump 2003 # 36. Nó khác với series Death Note bởi một quy tắc nếu chủ sở hữu của quyển sổ sử dụng Death Eraser để xóa tên trong Death Note các nạn nhân sẽ sống lại...",
                        Fakedate(3, 5, 1990), 0, 3.6, "http://cdn.truyentranh.net/upload/image/comic/20170321/death-note-death-eraser-58d08cf793577-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"Magic", "Comedy", "Adventure"};
        mangalist.add(new Manga("Doraemon Plus",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Doraemon Plus: Đây là loạt truyện tranh về Doraemon không nằm trong nguyên tác bốn mươi lăm tập ban đầu của Fujiko F. Fujio, và xuất bản như một quyển truyện chương hồi đặc biệt của loạt truyện ban đầu. Doraemon Plus được ra mắt vào năm 2005 với 5 tập. Tuy chỉ một năm ngắn ngủi mà đã có hơn 100 chương không bao gồm 5 tập đó đã được tung ra.",
                        Fakedate(3, 5, 2000), 0, 3.9, "http://cdn.truyentranh.net/upload/image/comic/20150318/Doraemon-Plus-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"Seinen", "Martial Arts", "Fantasy", "Adventure", "Action"};
        mangalist.add(new Manga("Against Fate Master",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Một kẻ mang danh Ni Ming Shi bị mai phục bởi Cấm Vệ Quân khi đi ngang rừng trúc. Dù suýt nữa đã qua mắt & thoát được nhưng chỉ huy đội Cấm Vệ Quân đã nhìn thấu chân tướng của Ni Ming Shi. Vì sao Cấm Vệ Quân lại muốn mạng hắn & liệu cái kết nào đang chờ Ni Ming Shi?",
                        Fakedate(3, 12, 1998), 0, 4.5, "http://cdn.truyentranh.net/upload/image/comic/20160708/ni-ming-shi-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"Romance", "Magic", "Drama", "Doujinshi"};
        mangalist.add(new Manga("Eine Kleine - Touhou Doujin",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Một dougin Touhou về tình cảm của bé phù thủy Marisa dành cho anh chủ tiệm Kourin",
                        Fakedate(3, 8, 2001), 0, 2.2, "http://cdn.truyentranh.net/upload/image/comic/20170327/eine-kleine-touhou-doujin-58d890a0a2f5e-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"Shounen", "Sci-Fi", "Fantasy", "Comedy", "Adventure", "Action"};
        mangalist.add(new Manga(".HACK//LINK",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Câu truyện bắt đầu vào năm 2020, ba năm sau sự kiện của Hack GU. Tokio Kuryuu là 1 học sinh trung học và chơi game Hack. tuy nhiên sự việc không đơn giản khi mà có sự xuất hiện của Saika Amagi, một cô gái bí ẩn, tuy nhiên trước đó Tokio đã 1 lần lạc vào The Worl R: X. và chứng kiến toàn bộ các nhân vật chính của phiên bản trước đó đã bị hóa đá, và vài sự kiện nho nhỏ mà rái hem ...n",
                        Fakedate(1, 2, 2001), 0, 3.0, "http://cdn.truyentranh.net/upload/image/comic/20150326/hack-link-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"Shounen", "Fantasy", "Drama", "Comedy", "Action"};
        mangalist.add(new Manga("Naruto",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Naruto là một cậu bé có mơ ước trở thành hokage của làng Konoha,được Hokage phong ấn trong người một trong 9 quái vật của thể giới : Cửu vĩ Hồ ly.Vì cho cậu là một con quái vật, ko ai dám chơi với cậu!& Vì muốn được thừa nhận nên rất phá phách.Khi tốt nghiệp trướng ninja, lần đầu tiên cậu đã được thừa nhận và có một người bạn thân là Sasuke.\n" +
                        "Hai năm sau, Sasuke đã rời bỏ làng lá để đi theo Orochimaru vì muốn đạt được sức mạnh hơn người, và dùng sức mạnh đó để giết người anh của mình.Naruto muốn đem Sasuke trở về, và vì Kakashi ko đủ trình độ nên đã đi theo Jiraiya - một trong tam nin truyền thuyết của Konoha - để học tập thêm cách dùng sức mạnh. Sau hai năm trờ về, Naruto đã 16 tuổi và có nhiều thay đổi! ",
                        Fakedate(2, 11, 2005), 0, 3.9, "http://cdn.truyentranh.net/upload/image/comic/20150318/Naruto-thumbnail-176x264.jpg"
                )
        );
        catetories = new String[]{"Manhua, Smut, Slice of Life, School Life"};
        mangalist.add(new Manga("18, Sống Chung Cùng Nhau",
                        new ArrayList<>(Arrays.asList(catetories)),
                        "dang ra", "Siêu hay nhé, kể về 1 cô gái 18 tuổi đi học xa nhà, cô đã phải bắt đầu chung sống với 1 cậu con trai, ngày đầu tiên họ đã kiss.",
                        Fakedate(3, 9, 2009), 0, 3.7, "http://cdn.truyentranh.net/upload/image/comic/20170202/18-song-chung-cung-nhau-5892af7e0ff49-thumbnail-176x264.jpg"
                )
        );

        mangalist.add(new Manga("Wortenia Senki",
                new ArrayList<>(Arrays.asList(catetories)),
                "dang ra", "Học sinh trung học Mikoshiba Ryouma bị triệu hồi đến 1 thế giới đang chìm trong chiến tranh. Cảm thấy ý định không tốt đẹp gì từ kẻ triệu hồi mình (1 triệu hồi sư của đế quốc O’ltormea), cậu đã giết chết một vài người quan trọng từ đế quốc trong lúc chạy trốn. Sau khi trốn thoát, cậu cứu 2 chị em sinh đôi từ 1 nhóm trộm cướp. Và từ đây cậu bắt đầu cuộc hành trình trở thành người thống trị!!",
                Fakedate(4, 8, 1980), 0, 3.8, "http://cdn.truyentranh.net/upload/image/comic/20170327/wortenia-senki-0-58d8761f709c3-59d4a2d25e488-thumbnail-176x264.jpg"
        ));
        catetories = new String[]{"Supernatural", "Shounen", "Historical", "Fantasy", "Adventure", "Action"};
        mangalist.add(new Manga("Chú Bé Rồng",
                new ArrayList<>(Arrays.asList(catetories)),
                "dang ra", "Đây là câu chuyện về hai cô cậu học trò ở Nhật Bản trong một lần đi dã ngoại với lớp đã được Rồng Thần đưa trở về thời Chiến Quốc vào ngay giữa trận chiến của Lưu Bị và Tào Nhân.... Chú bé Rồng là một bộ truyện tranh Nhật Bản do nhà văn Yoshito Yamahara chế tác dựa theo bộ truyện dã sử Trung Quốc \"Tam Quốc Diễn Nghĩa\". Điều làm cho bộ truyện này khác với nguyên bản \"Tam Quốc Diễn Nghĩa\" của nhà văn La Quán Trung là sự xuất hiện của hai nhân vật chính Koikichi và Masumi. Đây là câu chuyện về hai cô cậu học trò ở Nhật Bản trong một lần đi dã ngoại với lớp đã được Rồng Thần đưa trở về thời Chiến Quốc vào ngay giữa trận chiến của Lưu Bị và Tào Nhân. Được cứu mạng bởi quân sư Từ Thứ (nhưng chính điều đó cũng đã khiến anh ấy hi sinh) vì anh ta tin cậu bé này có \"thiên mệnh\". Cậu bé Koikichi vì cảm kích ơn cứu tử đã tạm thời trở thành quân sư cho phe Lưu Bị và nổi danh từ đó với cái tên Quân Sư Rồng. Câu chuyện bắt đầu từ đây...",
                Fakedate(4, 11, 1980), 0, 3.6, "http://cdn.truyentranh.net/upload/image/comic/20150326/chu-be-rong-thumbnail-176x264.jpg"
        ));
        catetories = new String[]{"Shounen", "Seinen", "Mystery", "Horror", "Adult"};
        mangalist.add(new Manga("Dead Tube",
                new ArrayList<>(Arrays.asList(catetories)),
                "dang ra", "Những cô nàng và show hàng nóng bỏng xung quanh câu truyện................đọc rồi sẽ rõ xD",
                Fakedate(8, 6, 1999), 0, 3.8, "http://cdn.truyentranh.net/upload/image/comic/20150318/dead-tube-5968d0d6e9827-thumbnail-176x264.jpg"
        ));
        catetories = new String[]{"Supernatural", "Shounen", "Action"};
        mangalist.add(new Manga("Dr. Stone",
                new ArrayList<>(Arrays.asList(catetories)),
                "dang ra", "Sau 1 trận đại dịch không rõ nguồn gốc khiến loài người trên toàn thể địa cầu biến thành đá trải qua mấy ngàn năm sau 2 thanh niên chính của chúng ta là Senkuu và Taiju phá đá thoát ra và bắt đầu lập kế hoạch để cùng nhau tái thiết lập lại thế giới theo cách của họ…",
                Fakedate(9, 9, 1999), 0, 1.2, "http://cdn.truyentranh.net/upload/image/comic/20170306/dr--stone1-58bccc6747b9f-thumbnail-176x264.jpg"
        ));

        String[] genres = {"Shounen", "Fantasy", "Comedy", "Adventure", "Action", "Martial Arts", "Harem", "Fantasy", "Adventure", "Action", "Supernatural", "Shounen", "Historical", "Fantasy", "Adventure", "Action", "Shounen", "Seinen", "Mystery", "Horror", "Adult", "Supernatural", "Shounen", "Action"};
        categories = new TreeSet<>();
        for (int i = 0; i < genres.length; i++) {
            categories.add(new Category(genres[i]));
        }
        int i = 0;
        for (Category item : categories) {
            item.setId(i);
            i++;
        }
    }
}
