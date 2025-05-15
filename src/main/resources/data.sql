-- 감정 데이터
INSERT INTO emotion (emotion_name) VALUES ('嬉しいです');
INSERT INTO emotion (emotion_name) VALUES ('疲れました');
INSERT INTO emotion (emotion_name) VALUES ('悲しいです');
INSERT INTO emotion (emotion_name) VALUES ('怒っています');
INSERT INTO emotion (emotion_name) VALUES ('混乱しています');
INSERT INTO emotion (emotion_name) VALUES ('無感覚です');
INSERT INTO emotion (emotion_name) VALUES ('ただ書いてみたかったです');

-- 기뻐요 (emotion_id = 1)
INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('朝の陽ざし', '今日は天気が本当に良くて、ピラティスに行こうとしたけど、思わず立ち止まってしまいました。\nもしかすると、私たちはこの些細な喜びを忘れて生きているのかもしれません。この日をずっと覚えていたいです。', 1, '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('発見は私を喜ばせる', '当たり前のことなんてこの世に一つもありません。\n呼吸できること、美味しいご飯を食べられること、両親が健康でいてくれること、すべてに本当に感謝しています。', 1, 'guest01');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('美味しいもののために生きてます', 'いつの間にか人生が退屈だと感じることが多くなりました。\nそんな時に私を支えてくれたのは、冷蔵庫の隅にあったチョコケーキでした。\n寝る前に「明日はチョコケーキを食べよう」と思いながら、明日を楽しみにしていました。', 1, 'user456');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('もう春ですか？', '人が快適に過ごせる温度は10度だと思います。\n暑くもなく寒くもないこの気温が一年中続けばいいのに。そんなことはないけどね（笑）', 1, 'tester');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('笑いが止まらなかった', '今日は「無限挑戦」と「思いっきりハイキック」をまた見たけど、本当に笑いが止まりませんでした。\n子供の頃も楽しく見ていたけど、今見てもやっぱり面白い！', 1, 'user456');

-- 지쳤어요 (emotion_id = 2)
INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('疲れて繰り返される一日', '一日中疲れていて、食事をするのも大変でした。\n忙しさの中で押し寄せる仕事、そして繰り返される毎日...\nこれが本当に私の望む人生なのか？この終わりはどこにあるのか？', 2, '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('就活中でとても憂鬱', '疲れました。\n就職活動が長引くにつれて、自分が本当にうまくやっているのか自信が持てません。\n勉強はしているけれど、やる気がなかなか出ません。すぐに気力が尽きてしまいました。', 2, 'guest123');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('エネルギーが尽きました', 'スマホを長く使うとバッテリー性能が落ちますよね？\nまさに今の私がそんな感じです。\n寝ても疲れが取れず、横になっていても無気力です。\n同じように感じている方はいませんか？', 2, 'guest01');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('疲れた心と体', '疲れました。人が使えるエネルギーは限られているのに、それ以上を求められている気がします。\nロウソクの蝋のように溶けていく感じです。', 2, 'tester');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('気力がありません', 'すべてに疲れました。辛いです。', 2, 'guest01');

-- 슬퍼요 (emotion_id = 3)
INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('雨のように涙が溢れた日', '今日は本当に悲しいです。\n心に雨が降っているような気分です。\nEpik Highの「傘」が聞きたくなります。', 3, '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('Netflixの「ザ・グローリー」、本当に悲しいですね', '最近話題になっていて、いくつかのクリップを見たのですが、涙が出ないエピソードがありませんでした。\n人の人生とは一体何なのでしょうか。', 3, 'anonymous');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('心が重かった', '捨て犬や捨て猫の記事を見ると本当に悲しくなります。\n理由もわからず、ただ飼い主を待ち続ける子たち…言葉も通じないので本当に胸が痛みます。', 3, 'guest123');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('私の慰めは届いたのだろうか', '親しい友人がとても悲しい出来事を経験したので慰めました。\nでも、あまり力になれなかった気がして、申し訳なくて悲しいです。', 3, 'guest01');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('空も泣いた日', 'どこかで大声で泣き叫びたい気分です。\n苦しいです。こんな時はどうすればいいのでしょうか？', 3, 'anonymous');

-- 화나요 (emotion_id = 4)
INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('イライラした一日', '今日バスを待っていたら、誰かが傘を私の方に向けて開きました。\nそのせいで背中に水がかかってとても不快だったのに、その人は謝りもせずに行ってしまいました。本当にマナーのない人だと思いました。', 4, '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('怒りを抑えられなかった日', '私は仕事をするときは静かに集中したいのに、最近やたらと連絡してきたり煩わしい人が増えました。\nきっと私に余裕がなくなっているのでしょう。こんな時は全部投げ出して休みたくなります…', 4, 'user456');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('ついカッとなってしまった', '思い出すだけでも腹が立つのであまり書きたくはないけれど、最近の人たちは本当にマナーがなくて、みんな怒りっぽい気がします。\n皆、心に余裕がないのでしょうね。\nでも、私も誰かの目にはそう見えているのかもしれません。', 4, 'guest01');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('ニュースを見ると怒りしか...', '世の中には悪い人が多すぎます。\n時間が経つほど、悪がどんどん多様化しているように感じます。', 4, 'tester');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('蒸し暑い一日', '暑いのにオフィスのエアコンが壊れました。本当にムカつく。', 4, 'guest01');

-- 혼란스러워요 (emotion_id = 5)
INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('混乱の連続', '就職活動をしながら、自分が誰なのか分からなくなる瞬間が増えています。\n私は何が好きだったんだろう？何をすべきなんだろう？\nそんなことを考えているうちに、不安と恐怖が突然押し寄せてきます。\n本当にうまくやっていけるのかな？', 5, '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('迷いだらけの一日', '私は選択することが本当に苦手です。選択肢が増えると逃げたくなります。\n誰かが代わりに決めてくれたらいいのに。', 5, 'guest01');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('ふむ…', '考えすぎると心の余裕がなくなります。\nでも、生まれつき考え込みやすい性格なので、「考えるのをやめよう」という考えすらやめたいです^^;;', 5, 'guest123');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('私を混乱させる人', '「ミンスは混乱している」という歌が聞きたくなりました。', 5, 'user456');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('混乱に陥った一日', 'すべてが混乱しています。', 5, 'guest01');

-- 무감각해요 (emotion_id = 6)
INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('何も感じない', '一日中無感覚でした。', 6, '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('ぼんやりした一日', '一日中無感覚でした。', 6, 'guest123');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('ただ過ぎていった一日', '特別なこともない平凡な一日の繰り返し。', 6, 'user456');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('無表情な一日', '今日は何回笑っただろう？気づけば鏡に映る自分の無表情な顔が目に留まりました。\n周りの生活にも興味がなくなり、この世をただ漂う板のような気分です。', 6, 'guest01');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('退屈', '一日中机に座っていても何も捗らず、もどかしい気分です。', 6, 'user456');

-- 그냥 써보고 싶었어요 (emotion_id = 7)
INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('とりあえず書いてみます', 'もともと記録するタイプではないですが、人生で自分の記録に助けられることが多いと感じます。\n今まさにそんな状況で、もっと詳しく書いておけばよかった…と後悔しています。\n過去にも今と似た感情を感じたことがあるので、その時どうやって乗り越えたのか思い出しています。', 7, '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('記録してみたい日', 'ただ書いてみたかったんです。大げさにせず、シンプルに自分のスタイルでやってみよう。\n他の人はどんな風に書いているのかな？', 7, 'anonymous');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('おすすめの曲', 'オ・ウネ - i wish。サイワールドのBGMでよく聞いていましたが、今聞いても良いですね。', 7, 'guest123');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('今日のひとことノート', '大げさな準備よりも、とにかく飛び込んで挑戦することが大事だと感じました。', 7, 'user456');

INSERT INTO diary (title, content, emotion_id, user_id)
VALUES ('私だけの実験', '今日は本当にただ書いてみたかったんです。無気力を乗り越えようと頑張っています。', 7, 'guest123');

-- 댓글 1개만 예시로
INSERT INTO comment (content, diary_id)
VALUES ('昨日は本当に楽しかったですね？雪が降ったかと思えば日差しが差してきて…とても不思議でした。これも幸せってやつじゃないでしょうか？（？）', 1);
