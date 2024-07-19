package com.sse.app.members;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sse.app.accounts.AccountDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AccountDAO accountDAO;

	private String name = "members";

	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {

		int result = memberDAO.join(memberDTO);

		if (files == null) {
			return result;
		}

// 		서블릿컨텍스트 객체를 통해서 운영체제랑 대화 하려고 만드는거(서블릿컨텍스트는 인터페이스라서 객체를 만들수가 없어서 세션에서 꺼내 쓰는거임)

		ServletContext servletContext = session.getServletContext();

//		1. 어디에 저장할 것인가(운영체제 기준으로 설명해줘야함)
		String path = servletContext.getRealPath("resources/upload/members");

		System.out.println(path);

//		그 저장경로가 없으면 만들어라
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}

//		2. 파일명을 뭐로 할 것인가(중복 없는 파일명) -> 시간 활용 or UUID
		Calendar calendar = Calendar.getInstance(); // 현재 날짜를 가져오는거
		long n = calendar.getTimeInMillis(); // 현재 날짜를 밀리세컨즈로 변환하는거
//		- 이 숫자 파일명에 파일의 확장자 붙여주기
		String fileName = files.getOriginalFilename();// 가져온 파일의 진짜 이름(ex ~~.jpg)
		fileName = n + "_" + files.getOriginalFilename();

		fileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
		System.out.println(fileName);

//		3. 하드디스크(HDD)에 파일을 저장(0과 1로 쪼개서)
//		파일 정보 준비
		file = new File(file, fileName);

//		저장방법이 2개 있음
//		 1) MultipartFile
//		files.transferTo(file);

//		 2)FileCopyUtils 라이브러리 활용
		FileCopyUtils.copy(files.getBytes(), file);

		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setMember_id(memberDTO.getMember_id());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(files.getOriginalFilename());

		memberDAO.joinFile(memberFileDTO);
		return result;

	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {

		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getMember_pw().equals(memberDTO.getMember_pw())) {

				return result;
			} else {
				return null;
			}
		}
		return null;
	}

	public MemberDTO update(MemberDTO memberDTO) throws Exception {

		int num = memberDAO.update(memberDTO);

		if (num > 0) {
			memberDAO.login(memberDTO);
		}
		return memberDTO;
	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);

	}

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return memberDAO.detail(memberDTO);
	}

}
