# library-management-system

・ホーム画面

http://localhost:8080/



・ユーザー
管理者ユーザー admin 
adminのパスワード: admin

パスワードはユーザー名と同じ


管理者権限を持つadmin
一部権限を持つstaff
権限を持たないuser

の三種類を実装

・図書管理

書籍の一覧表示

書籍の検索

書籍の追加・編集・削除

追加: 「STAFF」や「ADMIN」ロールのユーザーが新しい書籍を追加可能

編集: 書籍情報の更新が可能

削除: 「ADMIN」ロールのユーザーのみが書籍を削除可能


・貸出管理
貸出情報の一覧表示
貸出履歴の確認

未実装
貸出手続き: ユーザーが書籍を借りる手続きを行えるように
返却手続き: 借りた書籍を返却する手続きを行えるように


・システム構成

1. フロントエンド
テンプレートエンジン: Thymeleafを使用してサーバーサイドでHTMLを生成
テンプレート: templates ディレクトリ内にHTMLテンプレートを配置
例: book_list.html, rental_list.html, add_book.html など


2. バックエンド
フレームワーク: Spring Bootを使用

コントローラー: リクエストを処理するコントローラークラスが存在する
例: BookController, RentalController, UserController など。

サービス層: ビジネスロジックを実装するサービスクラスが存在
リポジトリ層: データベースとのやり取りを行うリポジトリインターフェースが存在


3. モデル（エンティティ）
User: ユーザー情報を表すエンティティ
プロパティ: id, username, password, roles など

Book: 書籍情報を表すエンティティ
プロパティ: id, title, author, publisher, category, quantity など

Rental: 貸出情報を表すエンティティ。
プロパティ: id, user, book, rentedDate, dueDate など

Role：adminなどのユーザーの改装分けエンティティ


4. セキュリティ
Spring Security: 認証とアクセス制御を担当
パスワードエンコーディング: パスワードはハッシュ化されてデータベースに保存される
アクセス制御: ユーザーのロールに基づいて、機能やページへのアクセスを制御する
Thymeleaf Extras Spring Security: テンプレート内でセキュリティ機能を利用するための拡張機能


5. データベース
MySQL
ORM: JPA（Jakarta Persistence API）とHibernateを使用してエンティティとデータベーステーブルをマッピング

  ・ORM(オブジェクト関係マッピング)の目的と利点

(1). オブジェクトとテーブルのマッピング
目的: オブジェクト指向のクラスとデータベースのテーブルを対応付けることで、プログラマがデータベース操作をオブジェクトとして扱えるようにする。
利点: SQLクエリを直接書く必要がなくなり、コードがより直感的で読みやすくなる。


(2). 生産性と保守性の向上
生産性: データベース操作に関するコード量が減り、開発スピードが向上する。
保守性: データベースのスキーマが変更されても、マッピング部分を修正するだけで済むため、影響範囲が小さくなる。


(3). データベースの独立性
利点: データベース固有のSQLから抽象化されるため、異なるデータベース間での移植性が高まる。


6. ビルド
ビルドツール: Maven
主要な依存関係:
spring-boot-starter-web
spring-boot-starter-thymeleaf
spring-boot-starter-data-jpa
spring-boot-starter-security
thymeleaf-extras-springsecurity6
mysql-connector-java
