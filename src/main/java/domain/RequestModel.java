package domain;


public class RequestModel {
	
	 private int id;
	 private String title;
	 private String body;
	 private int userId;
	 
	 public RequestModel() {}
	 
	 public RequestModel(int id, String title, String body, int userId) {
	        this.id = id;
	        this.title = title;
	        this.body = body;
	        this.userId = userId;
	        
	 }
	 
	 
	  // Getters and Setters (Jackson needs them)
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getTitle() { return title; }
	    public void setTitle(String title) { this.title = title; }

	    public String getBody() { return body; }
	    public void setBody(String body) { this.body = body; }
	    
	    public int getUserId() { return userId; }
	    public void setUserId(int userId) { this.userId = userId; }
	 
	 
	 @Override
	 public boolean equals(Object obj) {
		 
		 if(this == obj) return true;
		 if(null == obj) return false;
		 
		 RequestModel expected = (RequestModel)obj ;
		 
		 return this.id == expected.id 
				 && this.title.equals(expected.title)
				 && this.body.equals(expected.body)
				 && this.userId == expected.userId;
		 
	 }
	
}
