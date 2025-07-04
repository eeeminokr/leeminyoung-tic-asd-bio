package medical.common.progress;

import java.util.HashMap;

public class ProgressDetails {
	// class variables
	   private String taskId;
	   private int taskNum;
	   private long total=0;
	   private long totalProcessed=0;
	   private int statusNum=0;
	   private long mTotal=0;
	   private long mTotalProcessed=0;
	   private int zTotal = 0;
	   private int zTotalProcessed=0;
	   // field setters
		public void setzTotal(int zTotal) {
			this.zTotal = zTotal;
		}
	    public void setzTotalProcessed(int zTotalProcessed) {
			this.zTotalProcessed = zTotalProcessed;
		}
		public void setmTotal(long mTotal) {
			this.mTotal = mTotal;
		}
		public void setmTotalProcessed(long mTotalProcessed) {
			this.mTotalProcessed = mTotalProcessed;
		}
	   public void setStatusNum(int statusNum) {
			this.statusNum = statusNum;
		}
	   public void setTaskId(String taskId) {
	      this.taskId = taskId;
	   }
	   public void setTaskNum(int taskNum) {
		      this.taskNum = taskNum;
		   }
	   public void setTotal(long total) {
	      this.total = total;
	   }
	   public void setTotalProcessed(long totalProcessed) {
	      this.totalProcessed = totalProcessed;
	   }
	 
	   // toString() method which returns progress details in JSON format
	   public String sndString(){
	      return "{taskNum:"+this.taskNum
	    		  +",total:"+this.total
	    		  +",totalProcessed:"+this.totalProcessed
	    		  +",statusNum:"+this.statusNum
	    		  +",mTotal:"+this.mTotal
	    		  +",mTotalProcessed:"+this.mTotalProcessed
	    		  +",zTotal:"+this.zTotal
	    		  +",zTotalProcessed:"+this.zTotalProcessed
	    		  +"}";
	   }
	 
	   // a public static HashMap, which serves as a storage to store progress of different tasks
	   // with taskId as key and ProgressDetails object as value
	   public static HashMap<String, ProgressDetails> taskProgressHash = new HashMap<String, ProgressDetails>();
	   
	   public void reset(){
		   setTaskNum(0);
	       setTotal(0);
	       setTotalProcessed(0);
	       setStatusNum(0);
	       setmTotal(0);
	       setmTotalProcessed(0);
	   }
}
