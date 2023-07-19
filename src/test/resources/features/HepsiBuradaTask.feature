Feature: Hepsiburada OPTIIM Task

  Background:
    Given Kullanıcı "https://www.hepsiburada.com/" url'ine gider.
    When "https://www.hepsiburada.com/" sayfasına gidildiği doğrulanır.
    And Çerezleri kabul et butonuna tıklanır.


    Scenario: Sepete ekleme ve çıkarma kontrolleri senaryosu
      Given Kullanıcı giriş yap butonuna tıklar.
      When Kullanıcı login sayfasının geldiğini doğrular.
      And Kullanıcı e-posta adresi olarak "mehmetfurkangergin@gmail.com" değerini girer
      And E-posta sayfası giriş yap butonuna tıklar.
      Then Kullanıcı password değeri olarak "1719.Sefa" değerini girer
      And Password sayfası giriş yap butonuna tıklar.
      And Arama alanına "samsung" yazılır ve arama butonuna tıklanır.
      And Sol menüden sırasıyla telefon takiben cep telefonu tıklanır.
      Then Gelen sayfada "samsung" için sonuç bulunduğu doğrulanır.
      And Üstten 5. ürün tıklanır.
      And Ürün detayında beğen butonuna tıklanır.
      Then "Ürün listenize eklendi." popup yazısının görüldüğü doğrulanır.
      And Hesabım alanında beğendiklerim tıklanır.
      Then Beğendiğim ürünün listemde olduğu doğrulanır.
      And Kullanıcı beğendiği ürünü sepete ekler.
      Then "Ürün sepete eklendi" popup yazısının görüldüğü doğrulanır.
      And Kullanıcı sepetim butonuna tıklar.
      Then Sepetim sayfasının açıldığı doğrulanır.
      And Kullanıcı sepetteki ürün için kaldır butonuna tıklar.
      Then "Ürün sepetinizden kaldırıldı" popup yazısının görüldüğü doğrulanır.
      Then Sepetin şu an boş yazısının çıktığı doğrulanır.


