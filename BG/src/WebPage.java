

import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	
	public String url;
	//public String name;
	public HtmlProcessor HtmlProcessor =new HtmlProcessor();
	public double score;
	public WebPage(String url) throws IOException {
		this.url = url;
		
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		HtmlProcessor.setContent(url);
		this.score = 0;
		for(Keyword k: keywords) {
			this.score += HtmlProcessor.countKeywordScore(k);
			this.score += HtmlProcessor.countAssociatedScore(k);
		}
	}
	
}
