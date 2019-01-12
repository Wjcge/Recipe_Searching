
import java.io.IOException;
import java.util.ArrayList;

public class TreeProccessor {
	public ArrayList<WebTree> trees  = new ArrayList<WebTree>();
	public ArrayList<Keyword> keywords = new ArrayList<Keyword>();
	
	public void setTreeList(ArrayList<String> urlList) throws IOException {
		for(String url: urlList) {
			trees.add(generateTree(url));
		}
	}
	
	public void setTreeList(String[][] googleResult) throws IOException {
		for(int i=0; i<googleResult.length; i++) {
			
				trees.add(generateTree(googleResult[i][1]));
				trees.get(i).setTiltle(googleResult[i][0]);
				System.out.println(i*100/googleResult.length+"%");
			
			
		}
	}
	
	public String[][] outputSortedResult(){
		String[][] sortedResult = new String[trees.size()][2];
		for(int i=0; i<trees.size(); i++) {
			sortedResult[i][0] = trees.get(i).title;
			sortedResult[i][1] = trees.get(i).rootUrl;
		}
		return sortedResult;
	}
	
	
	public void setKeywordList(ArrayList<Keyword> keywords) {
		this.keywords=keywords;
	}
	
	public void sortTreeList() {
		for(int i=0; i<trees.size()-1; i++) {
			for(int j=0; j<trees.size()-1; j++) {
				if(trees.get(j).treeScore< trees.get(j+1).treeScore) {
					WebTree tempTree1 = trees.get(j);
					WebTree tempTree2 = trees.get(j+1);
					trees.set(j, tempTree2);
					trees.set(j+1, tempTree1);
					
				}
			}
		}
	}
	
	public void printTreeList() {
		for (WebTree tree:trees) {
			System.out.println("url: "+tree.rootUrl);
			System.out.println("score: "+tree.treeScore);
			System.out.println("-----");
		}
	}
	
	public WebTree generateTree(String url) throws IOException {
		
		HtmlProcessor htmlProcessor = new HtmlProcessor();
		WebPage rootPage = new WebPage(url);
		WebTree tree = new WebTree(rootPage);
		htmlProcessor.setContent(rootPage.url);
		for (String childUrl:htmlProcessor.findUrl()) {
			tree.root.addChild(new WebNode(new WebPage(childUrl)));
		}
		/*
		for (WebNode child:tree.root.children) {
			htmlProcessor.setContent(child.webPage.url);
			for (String grandSonUrl:htmlProcessor.findUrl()) {
				child.addChild(new WebNode(new WebPage(grandSonUrl)));
			}
		}*/

		tree.setPostOrderScore(keywords);

		return tree;	
	
	}
}