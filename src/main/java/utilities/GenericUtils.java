package utilities;

import java.io.File;

public class GenericUtils {

	public static File getLatestFileFromDir(String sDirPath){
		File dir = new File(sDirPath);
		File[] files = dir.listFiles();
		if(files==null || files.length == 0){
			return null;
		}
		File lastModifiedFile = files[0];
		for(int i=0;i<files.length;i++){
			if(lastModifiedFile.lastModified() < files[i].lastModified()){
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
}
