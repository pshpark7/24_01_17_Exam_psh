import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int lastId = 0;
		List<WiseSaying> wisesayings = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		System.out.println("== 명언 앱 실행 ==");

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println(" 명령어를 입력하세요");
				continue;
			}
			if (cmd.equals("종료")) {
				break;
			}
			if (cmd.equals("등록")) {

				int id = lastId + 1;

				System.out.print("명언 : ");
				String content = sc.nextLine();
				System.out.print("작가 : ");
				String author = sc.nextLine();
				String regDate = formatedNow;

				WiseSaying wisesaying = new WiseSaying(id, content, author, regDate);
				wisesayings.add(wisesaying);

				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				lastId++;

			} else if (cmd.equals("목록")) {
				System.out.println("번호  /  작가  /  명언");
				System.out.println("=============================");
				
				if (wisesayings.size() == 0) {
					continue;
				}

				for (int i = wisesayings.size() - 1; i >= 0; i--) {
					WiseSaying ws = wisesayings.get(i);
					System.out.printf("%d  /  %s  /  %s \n", ws.getId(), ws.getAuthor(), ws.getContent());
				}
			} else if (cmd.startsWith("수정")) {
				String[] cmdBits = cmd.split("\\?", 2);
				String[] cmdBits2 = cmdBits[1].split("=", 2);

				int id = Integer.parseInt(cmdBits2[1]);
				WiseSaying foundws = null;

				for (int i = 0; i < wisesayings.size(); i++) {
					WiseSaying wisesaying = wisesayings.get(i);
					if (wisesaying.getId() == id) {
						foundws = wisesaying;
					}
				}
				if (foundws == null) {
					System.out.printf("%d번 명언은 없습니다.\n", id);

				} else {
					System.out.println("명언(기존) : " + foundws.getContent());
					System.out.println("작가(기존) : " + foundws.getAuthor());

					System.out.print("명언 : ");
					String newContent = sc.nextLine();
					System.out.print("작가 : ");
					String newAuthor = sc.nextLine();

					foundws.setContent(newContent);
					foundws.setAuthor(newAuthor);

					System.out.printf("%d번 명언이 수정되었습니다.\n", id);

				}
			} else if (cmd.startsWith("삭제")) {
				String[] cmdBits = cmd.split("\\?", 2);
				String[] cmdBits2 = cmdBits[1].split("=", 2);

				int id = Integer.parseInt(cmdBits2[1]);
				WiseSaying foundws = null;

				for (int i = 0; i < wisesayings.size(); i++) {
					WiseSaying wisesaying = wisesayings.get(i);
					if (wisesaying.getId() == id) {
						foundws = wisesaying;
					}
				}
				if (foundws == null) {
					System.out.printf("%d번 명언은 없습니다.\n", id);

				} else {
					wisesayings.remove(foundws);
					System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

				}
			}else if (cmd.startsWith("상세보기")) {
				String[] cmdBits = cmd.split("\\?", 2);
				String[] cmdBits2 = cmdBits[1].split("=", 2);

				int id = Integer.parseInt(cmdBits2[1]);
				WiseSaying foundws = null;

				for (int i = 0; i < wisesayings.size(); i++) {
					WiseSaying wisesaying = wisesayings.get(i);
					if (wisesaying.getId() == id) {
						foundws = wisesaying;
					}
				}
				if (foundws == null) {
					System.out.printf("%d번 명언은 없습니다.\n", id);

				} else {
					System.out.println("번호 : "+ foundws.getId());
					System.out.println("날짜 : "+ foundws.getRegDate());
					System.out.println("작가 : "+ foundws.getAuthor());
					System.out.println("내용 : "+ foundws.getContent());

				}
			}

			else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}


		sc.close();
	}
}