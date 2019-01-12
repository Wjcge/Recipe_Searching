import java.util.ArrayList;

public class DefaultKeyword {
	ArrayList<Keyword> keywords = new ArrayList<Keyword>();
	
	public DefaultKeyword() {
		//video 
		this.keywords.add(new Keyword("video",500));
		//
		this.keywords.add(new Keyword("img",300));
		this.keywords.add(new Keyword(".jpg",300));
		
		//else
		this.keywords.add(new Keyword("食譜",30));
		this.keywords.add(new Keyword("recipe",30));
		this.keywords.add(new Keyword("做法",30));
		this.keywords.add(new Keyword("菜",30));
		this.keywords.add(new Keyword("cook",30));
		
		//number and others
		this.keywords.add(new Keyword("毫升",300));
		this.keywords.add(new Keyword("少許",300));
		this.keywords.add(new Keyword("杯",30));
		this.keywords.add(new Keyword("g ",300));
		this.keywords.add(new Keyword("克",300));
		this.keywords.add(new Keyword("勺",300));
		this.keywords.add(new Keyword("c.c",300));
		this.keywords.add(new Keyword("匙",30));
		this.keywords.add(new Keyword("碗",30));
		this.keywords.add(new Keyword("顆",30));
		this.keywords.add(new Keyword("條",30));
		this.keywords.add(new Keyword("把",30));
		this.keywords.add(new Keyword("適量",30));
		this.keywords.add(new Keyword("包",30));
		this.keywords.add(new Keyword("片",30));
		this.keywords.add(new Keyword("塊",30));
		this.keywords.add(new Keyword("粒",30));
		this.keywords.add(new Keyword("薄片",30));
		this.keywords.add(new Keyword("絲",30));
		this.keywords.add(new Keyword("比例",30));
		this.keywords.add(new Keyword("油",30));
		this.keywords.add(new Keyword("鹽",30));
		this.keywords.add(new Keyword("糖",30));
		this.keywords.add(new Keyword("水",30));
		this.keywords.add(new Keyword("酌量",30));
		
		//action
		this.keywords.add(new Keyword("切",30));
		this.keywords.add(new Keyword("蒸",30));
		this.keywords.add(new Keyword("炸",30));
		this.keywords.add(new Keyword("烤",30));
		this.keywords.add(new Keyword("悶",30));
		this.keywords.add(new Keyword("搓",30));
		this.keywords.add(new Keyword("加",30));
		this.keywords.add(new Keyword("沾",30));
		this.keywords.add(new Keyword("燉",30));
		this.keywords.add(new Keyword("鋪",30));
		this.keywords.add(new Keyword("熱",30));
		this.keywords.add(new Keyword("醃",30));
		this.keywords.add(new Keyword("打",30));
		this.keywords.add(new Keyword("融化",30));
		this.keywords.add(new Keyword("凝固",30));
		this.keywords.add(new Keyword("炒",30));
		this.keywords.add(new Keyword("煎",30));
		this.keywords.add(new Keyword("撒",30));
		this.keywords.add(new Keyword("煨",30));
		this.keywords.add(new Keyword("倒",30));
		this.keywords.add(new Keyword("揉",30));
		this.keywords.add(new Keyword("煮",30));
		this.keywords.add(new Keyword("盛",30));
		this.keywords.add(new Keyword("沸",30));
		this.keywords.add(new Keyword("撈",30));
		this.keywords.add(new Keyword("爆香",30));
		this.keywords.add(new Keyword("滷",30));
		this.keywords.add(new Keyword("熟",30));
		this.keywords.add(new Keyword("壓",30));
		this.keywords.add(new Keyword("抹",30));
		this.keywords.add(new Keyword("靜置",30));
		this.keywords.add(new Keyword("發酵",30));
		this.keywords.add(new Keyword("拌",30));
		this.keywords.add(new Keyword("撈",30));
		this.keywords.add(new Keyword("混合",30));
		this.keywords.add(new Keyword("備用",30));
		this.keywords.add(new Keyword("步驟",30));
		this.keywords.add(new Keyword("碎",30));
		this.keywords.add(new Keyword("勻",30));
		this.keywords.add(new Keyword("燙",30));
		this.keywords.add(new Keyword("泡",30));
		this.keywords.add(new Keyword("洗",30));
		this.keywords.add(new Keyword("割",30));
		this.keywords.add(new Keyword("擀",30));
		this.keywords.add(new Keyword("熬",30));
		this.keywords.add(new Keyword("焙",30));
		this.keywords.add(new Keyword("燻",30));
		this.keywords.add(new Keyword("稀釋",30));
		this.keywords.add(new Keyword("焗",30));
		this.keywords.add(new Keyword("漬",30));


		
		//unrelated
		this.keywords.add(new Keyword("推薦",-500));
		this.keywords.add(new Keyword("必吃",-500));
		this.keywords.add(new Keyword("地址",-500));
		this.keywords.add(new Keyword("電話",-500));
		this.keywords.add(new Keyword("營業時間",-500));
		this.keywords.add(new Keyword("維基",-100000));
		this.keywords.add(new Keyword("新聞",-100000));
		this.keywords.add(new Keyword("news",-100000));
		this.keywords.add(new Keyword("wiki",-100000));

		//time
		this.keywords.add(new Keyword("分鐘",500));
		this.keywords.add(new Keyword("小時",50));
		this.keywords.add(new Keyword("度",500));
		this.keywords.add(new Keyword("℃",50));

	}
	public void setKeyword(Keyword keyword	) {
		this.keywords.add(keyword);
	}
	
	
}
