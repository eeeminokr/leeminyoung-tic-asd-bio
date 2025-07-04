package medical.common.progress;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProgressMonitor extends HttpServlet {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      // get the taskId
		      String taskId = request.getParameter("taskIdentity");
//		      System.out.println("taskId ===> " + taskId);
		      // get the progres of this task
		      ProgressDetails taskProgress = ProgressDetails.taskProgressHash.get(taskId);
		      if(taskProgress !=null){
		    	// write the progress in the response
//			      System.out.println("taskProgress.toString() ===> " + taskProgress.sndString());
		      }else{
		    	  taskProgress = new ProgressDetails();
		    	  taskProgress.setTaskId("9999");
		    	  taskProgress.setTaskNum(0);
		    	  taskProgress.setTotal(0);
		    	  taskProgress.setTotalProcessed(0);
		    	  taskProgress.setzTotal(0);
		    	  taskProgress.setzTotalProcessed(0);
		      }
		      response.setContentType("text/html; charset=UTF-8");
		      response.getWriter().print(taskProgress.sndString());
		   }
		}
