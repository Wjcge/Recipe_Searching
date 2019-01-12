

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HtmlProcessor {
	
	private String urlStr;
	public String content;
	public ArrayList<String> tokenslist =new ArrayList<String>();
	double LCSstandard = 0.75; //LCS分數高於標準*字長度才算相關字
	
	
	public void setContent(String urlStr) throws IOException {
		this.urlStr=urlStr;
		content = fetchContent();
		content = content.toLowerCase();
		
		
	}
	
	public void setTokenslist(String content) {
		String [] tokens = content.split(":|-|_|\"|>|<| |/|=|\\r\\n|\\.|，|。|、|的|是|：");
		for(String token :tokens) {
			if(!token.equals("")) {
				tokenslist.add(token);
			}
		}
	}
	
	public void addToken(String token) {
		this.tokenslist.add(token);
	}
	
	public double countAssociatedScore(Keyword k) {
		setTokenslist(content);
		double score = 0;
		for(int i = 0; i< this.tokenslist.size();i++) {
			int lcs = findLCS(this.tokenslist.get(i), k.name);
			
			//判斷方式雙向可能有bug?
			if(lcs >= k.name.length()*LCSstandard ) {
				score=score+k.weight*LCSstandard; //分數也加權
			}
		}
		return score;
	}
	
	public int findLCS(String x, String y) {
		int n =x.length();
		int m = y.length();
		int[][] lcs = new int[n+1][m+1];
		
		lcs[0][0]=0;
		for(int i =1; i<=n;i++) {
			lcs[i][0]=0;
		}
		for(int j =1; j<=m;j++) {
			lcs[0][j]=0;
		}
		
		for(int i = 1;i<=n;i++) {
			for(int j =1; j<=m;j++) {
				if(x.charAt(i-1)==y.charAt(j-1)) {
					lcs[i][j]=lcs[i-1][j-1] + 1;
				}else {
					if(lcs[i-1][j]>lcs[i][j-1]) {
						lcs[i][j]=lcs[i-1][j] ;
					}else {
						lcs[i][j]=lcs[i][j-1];
					}
				}
			}
		}
		return lcs[n][m];
		
	}
	
	private String fetchContent() throws IOException{
		String retVal = "";
		try {
			URL url = new URL(this.urlStr);
			URLConnection conn=url.openConnection();
			InputStream in =conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			
			while((line = br.readLine()) !=null) {
				retVal = retVal + line +"\n";
			}
		}catch(java.io.IOException ex) {
			System.out.println("HtmlProcessor fetchContent fail in "+ urlStr);
		}
		
		return retVal;	
	}
	
	public double countKeywordScore(Keyword keyword) throws IOException{
		
		String name = keyword.name.toLowerCase();
		double weight = keyword.weight;
		int index = 0;
		double score = 0;
		while(index != -1) {
			index = content.indexOf(name);
			if(index != -1) {
				score=score+weight;
				content=content.substring(index + name.length());
			}
		}
		return score;
	}
	
	public ArrayList<String> findUrl() throws IOException{

		ArrayList<String> urlList = new ArrayList<String>();
		int indexOfOpen=0;
		String  urlTag = "href=\"http:";
		
		if(content.indexOf(urlTag,0) == -1) {
			System.out.println("can not find sub url in "+urlStr);
		}
		
		while(content.indexOf(urlTag,indexOfOpen) != -1) {
			indexOfOpen= content.indexOf(urlTag,indexOfOpen)+urlTag.length();
			int indexOfClose= content.indexOf("\"", indexOfOpen) ;
			String urlFind = "https:"+content.substring(indexOfOpen, indexOfClose);
			content = content.substring(indexOfClose);
			urlList.add(urlFind);
		}
		
		
		
		return urlList;
	}
}