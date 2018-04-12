package util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ExtractRARTest {

	@Test
	void test() throws Exception {
		String zipOrRarName = "C:\\Users\\yj936\\Desktop\\五台三.zip";
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		String dirName = sdf.format(new Date());
		String extractPlace = "C:\\Users\\yj936\\Desktop\\"+dirName;//生成当日日期命名的文件夹

		if (zipOrRarName.endsWith(".zip")) {
			util.ExtractRAR.unzip(zipOrRarName, extractPlace);
		} else if (zipOrRarName.endsWith(".rar")) {
			util.ExtractRAR.untar(zipOrRarName, extractPlace);
		}
		File file = new File(extractPlace);
		if(file.isDirectory()) {
			String[] fileList = file.list();
			for (String f : fileList) {
				File delf = new File(extractPlace + File.separator + f);
				if(f.endsWith(".txt")) {
					delf.delete();
				}
			}
		}
	}

}
