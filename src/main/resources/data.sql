-- 감정 데이터
INSERT INTO emotion (emotion_name) VALUES ('기뻐요');
INSERT INTO emotion (emotion_name) VALUES ('지쳤어요');
INSERT INTO emotion (emotion_name) VALUES ('슬퍼요');
INSERT INTO emotion (emotion_name) VALUES ('화나요');
INSERT INTO emotion (emotion_name) VALUES ('혼란스러워요');
INSERT INTO emotion (emotion_name) VALUES ('무감각해요');
INSERT INTO emotion (emotion_name) VALUES ('그냥 써보고 싶었어요');

-- 기뻐요 (emotion_id = 1)
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('아침 햇살', '오늘 날씨가 정말 좋았는데, 필라테스를 가려다가 잠시 멈출 정도였다. \n어쩌면 우리는 이 사소한 기쁨을 잊고 살던 것은 아니었을까?, 이 날이 두고두고 생각났으면 좋겠어요', 1, 'user456');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('발견은 나를 기쁘게 해', '당연한 것은 이 세상에 하나도 없더라고요.\n내가 숨쉬는 것도 감사하고 맛있는 밥을 먹는 것도, 부모님이 건강하신 것도 정말 감사해요.', 1, 'guest01');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('맛있는 거 먹으려고 삽니다.', '어느 순간부터 사는 것이 지겹다는 생각이 들 때가 많았어요.\n그때 저를 이겨내게 도와줬던 것은 냉장고 한 구석에 숨쉬고 있던 초코케이크였어요.\n잠들기 전에 아 내일 초코케이크 먹어야지. 그 생각으로 내일을 기다렸어요.', 1, 'user456');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('이제 봄인가요?', '사람이 살기 딱 좋은 온도는 10도라고 생각해요. \n덥지도 춥지도 않은 온도. 이 날씨가 1년 내내 갔으면 좋겠어요. 그럴리는 없지만요 ㅋㅋㅋ', 1, 'tester');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('웃음이 멈추지 않았다', '오늘 무한도전이랑 거침없이 하이킥을 다시 봤는데 진짜 너무 웃겼다.\n어렸을 때에도 참 재밌게 봤는데 지금봐도 재밌네!', 1, 'user456');

-- 지쳤어요 (emotion_id = 2)
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('지치고 반복되는 하루', '하루 종일 지쳐서 먹는 것도 힘이 들었다.\n너무 바쁘고 일이 밀려들어 오는 와중에 반복되는 하루...\n이게 정말 내가 원하는 삶인건가? 이 끝은 어딘건가?', 2, 'guest01');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('취준중 너무 우울', '지쳤어요.\n취준이 길어지면서 내가 정말 잘하고 있는 것인지 믿음이 안가요.\n공부는 하는데 의욕이 잘 나지 않아요. 금방 바닥나버렸어요', 2, 'guest123');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('에너지가 바닥났어요', '핸드폰을 오래쓰면 배터리 성능이 내려가잖아요?\n제가 딱 그런 것 같습니다.\n잠을 자도 잔 것처럼 개운하지 않고, 누워있어도 무기력해져요.\n저와 같은 분이 계실까요?', 2, 'guest01');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('지친 몸과 마음', '피곤해요. 사람이 쓸 수 있는 에너지의 양은 한정되어 있는데 그 이상의 것을 요구하는 것 같아요.\n촛농처럼 녹아내려요.', 2, 'tester');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('기력이 없어요', '모든 게 지쳤어요. 힘들어요', 2, 'guest01');

-- 슬퍼요 (emotion_id = 3)
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('비처럼 눈물난 날', '오늘은 정말 슬퍼요.\n마음에 비가 내리는 것 같아요.\n에픽하이의 우산이 듣고 싶어지네요', 3, 'tester');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('넷플릭스 폭싹 속았수다 진짜 슬프네요', '요새 엄청 핫해서 클립 몇 개를 봤는데 아주 그냥 눈물이 안 나오는 에피소드가 없네요\n사람 인생이란 무엇일까요?', 3, 'anonymous');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('마음이 무거웠어요', '유기견, 유기묘에 대한 글을 보면은 너무 슬퍼요.\n영문도 모른채 그저 주인만을 기다리는 아이들.. 말도 통하지 않으니 너무 가슴이 아프더라고요.', 3, 'guest123');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('내가 위로가 되었을까요', '친한 친구가 너무 슬픈 일을 겪었다고 해서 위로를 해줬어요.\n하지만 제가 큰 도움이 되지 못한 것 같아서 미안하고 슬프네요', 3, 'guest01');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('하늘도 울었던 날', '어딘가에 가서 크게 소리지르며 통곡하고 싶어요.\n답답합니다. 이런 경우 무엇을 해야할까요?', 3, 'anonymous');

-- 화나요 (emotion_id = 4)
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('짜증나는 하루', '오늘 버스를 타려고 기다리는데 누가 우산을 내 쪽을 향해서 폈다.\n덕분에 등에 물이 튀어서 너무 찝찝하고 그 사람은 사과도 없이 갔다. 정말 매너 없는 사람', 4, 'tester');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('화를 참기 어려웠던 날', '나는 일을 할 때는 조용히 하고 싶은데, 요새 들어 연락이나 귀찮게 하는 사람들이 많아졌다.\n내가 많이 여유가 없나보다. 이럴 때에는 다 내팽겨치고 싶고 쉬고 싶어...', 4, 'user456');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('버럭하고 말았어요', '떠올리는 것 조차 화가 나서 그다지 쓰고 싶지는 않지만, 요새 사람들은 너무 매너도 없고 화가 많은 것 같다.\n다들 여유가 없나보다.\n하지만 나 조차도 누군가의 눈에 그렇겠지?', 4, 'guest01');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('뉴스를 보면 분노밖에...', '세상에는 악한 사람들이 너무 많다.\n시간이 지날수록 악은 너무 다채로워지는 느낌이 든다.', 4, 'tester');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('끈적거리는 하루', '더운데 사무실에 에어컨이 고장났다. 정말 개빡쳐', 4, 'guest01');

-- 혼란스러워요 (emotion_id = 5)
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('혼란의 연속', '취준을 하면서 내가 누구인지 알 수가 없어지는 순간들이 많아진다.\n나는 무엇을 좋아했더라? 나는 무엇을 해야할까? 그러다보면은 어느순간부터 불안감과 두려움이 나를 덮친다.\n내가 정말 잘해낼 수 있을까?', 5, 'guest01');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('갈피를 못 잡겠는 하루', '저는 선택을 하는 것이 너무 어렵습니다. 선택지가 많아지면 도망가고 싶어요.\n누군가가 대신 정해줬으면 좋겠어요.', 5, 'guest01');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('흠...', '생각이 많으면 여유가 없어진다.\n하지만 선천적으로 생각이 많은 편이라 생각을 그만하라는 생각도 그만하고 싶다^^ㅠㅠ', 5, 'guest123');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('나를 헷갈리게 하는 사람', '민수는 혼란스럽다.라는 노래가 듣고 싶어진다.', 5, 'user456');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('혼란에 빠졌던 하루', '모든 게 혼란스러워요.', 5, 'guest01');

-- 무감각해요 (emotion_id = 6)
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('아무 감정도 들지 않아', '하루 종일 무감각해요.', 6, 'anonymous');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('멍한 하루', '하루 종일 무감각해요.', 6, 'guest123');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('그냥 그렇게 흘러간 하루', '특별한 것없는 평범한 하루의 반복', 6, 'user456');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('무표정한 하루', '하루에 내가 몇 번이나 웃더라? 어느순간부터 거울을 보니 아무런 표정이 없는 얼굴이 눈에 띈다\n주변의 삶에 관심도 사라지고 그냥 이 세상에 둥둥 표류하는 판자같은 느낌이다.', 6, 'guest01');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('지루해', '하루종일 책상에 앉아서 아무것도 능률이 안오르니 답답해요.', 6, 'user456');

-- 그냥 써보고 싶었어요 (emotion_id = 7)
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('일단 써봅니다', '원래 기록쟁이는 아니지만, 살다보면 내가 기록한 것에 도움을 받을 때가 많다고 느낀다.\n내가 지금 그런 상황인데, 조금 더 자세히 적어둘걸..!이라고 후회하고 있는 중이다\n과거에도 현재와 비슷한 감정을 느꼈던 때가 있었기 때문에 그때 내가 어떻게 대처했더라?', 7, 'tester');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('기록해보고 싶은 날', '그냥 써보고 싶었어요. 거창할 것도 없이 소박하게 내 스타일대로 가보자고.\n다른 사람들은 어떤 식으로 글을 쓰려나?', 7, 'anonymous');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('노래 추천', '오은혜-i wish. 싸이월드에 브금으로 많이 들었는데 지금 들어도 좋다.', 7, 'guest123');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('오늘 짤막한 노트', '거창한 준비보다 그냥 뛰어들고 도전해보는 것이 중요하다고 생각이 들었어요.', 7, 'user456');
INSERT INTO diary (title, content, emotion_id, user_id) VALUES ('나만의 실험', '오늘은 정말 그냥 써보고 싶었어요. 무기력을 이겨내려고 노력중이에요', 7, 'guest123');

-- 댓글 1개만 예시로
INSERT INTO comment (content, diary_id) VALUES ('어제 참 재밌더라고요? 어제는 눈이 오다가 햇빛이 비추는 게 너무 신기하고.. 이것도 행복 아닐까요?(?)', 1);
