

import java.io.IOException;
import java.util.ArrayList;

public class WebTree {
	public WebNode root;
	public double treeScore ;
	public String rootUrl;
	public String title;
	
	public WebTree(WebPage rootPage) {
		this.root = new WebNode(rootPage);
		rootUrl = root.webPage.url;
	}
	
	public void setTiltle(String tilte) {
		this.title=tilte;
	}
	
	public void setPostOrderScore (WebNode startNode,ArrayList<Keyword> keywords) throws IOException {
		for (WebNode child : startNode.children) {
			setPostOrderScore(child, keywords);
		}
		startNode.setNodeScore(keywords);
	}
	
	public void setPostOrderScore (ArrayList<Keyword> keywords) throws IOException {
		setPostOrderScore(root,keywords);
		this.treeScore = root.nodeScore;
	}
	
	public void printTree(WebNode webNode) {
		
		for( int j = 0;j<webNode.getDepth()-1; j++) {
			System.out.print("\t");
		}
		
		System.out.print("("+webNode.webPage.url+","+webNode.nodeScore);
		if(webNode.children.isEmpty()) {
			System.out.print(")");
		}else{
			for(WebNode child: webNode.children) {
				System.out.print("\n");
				printTree(child);		
			}
			
			System.out.print("\n");
			for( int j = 0;j<webNode.getDepth()-1; j++) {
				System.out.print("\t");
			}
			System.out.print(")");
		}
		
		
		
	}
	
	public void printTree() {
		printTree(root);
	}
	
}
