package com.sse.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

//		Iterator<String> keys = model.keySet().iterator();

//		while (keys.hasNext()) {
//			String k = keys.next();
//			System.out.println(k);
//		}

		FileDTO fileDTO = (FileDTO) model.get("file");
		String directory = (String) model.get("board");

//		1.폴더 경로 준비
		String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + directory);

//		2. 파일 준비
		File file = new File(path, fileDTO.getFileName());

//		3. 응답시 인코딩 처리(Filter로 처리 했으면 선택)
		response.setCharacterEncoding("UTF-8");

//		4. 파일의 크기 지정
		response.setContentLength((int) file.length());

//		5.다운로드 시 파일 이름을 지정,이름이 한글일수 있어서 이것도 인코딩
		String name = fileDTO.getOriName();
		name = URLEncoder.encode(name, "UTF-8");

//		6. Header 정보 설정 (데이터 정보를 담고 있는 것)
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + name + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");

//		7. 클라이언트에게 전송(0과 1로 만들어서)
//		HDD에서 파일을 읽어와서 Client로 output

		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
//		파일에서 읽어온거를 카피 해서 아웃풋으로 내보내라
		FileCopyUtils.copy(fi, os);

//		8. 자원을 썼으면 해제해주기
		os.close();
		fi.close();

		System.out.println("File Down View");

	}

}
