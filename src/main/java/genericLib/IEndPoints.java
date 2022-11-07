package genericLib;

public interface IEndPoints {
	String getoperation = "/repos/{owner}/{repo}";
	String postoperation = "/user/repos";
	String updateoperation = "/repos/{owner}/{repo}";
	String deleteoperation = "/repos/{owner}/{repo}";
	
	String propertyfilepath = "./data.properties";

}
