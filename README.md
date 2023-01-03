Bu eğitimde https://github.com/osmanizbat/cicd-training-1 eğitiminde Virtualbox üzerinde hazırlamış olduğumuz __jenkins__ ve __app-server__ sanal sunucularıyle çalışmaya devam ediyoruz.

# Jenkins sunucusuna Docker kurulumu

1. APT ile gerekli paket kurulur
    ~~~
    sudo apt install docker.io
    ~~~

2. Docker çalıştığını test etmek için hello-world imajıyla bir container çalıştırılır
    ~~~ 
    sudo docker run --rm hello-world
    ~~~

3. Docker komutlarını sudo gerekmeden çalıştırabilmek için ilgili user'ları docker grubuna ekliyoruz.
    ~~~ 
    sudo usermod -aG docker $USER
    sudo usermod -aG docker jenkins
    sudo systemctl restart jenkins
    exit
    ~~~

4. Kendi build ettiğimiz imajları host edebilmek için Docker registry container'ını çalıştırıyoruz.    
    ~~~
    docker run -d -p 5000:5000 --restart=always --name registry registry:2
    ~~~

# app-server sunucusunun hazırlanması

1. Yukarıdaki bölümdeki 1, 2 ve 3. adımlar bu sunucuda da uygulanır.

2. docker-compose paketi kurulur
    ~~~
    sudo apt install docker-compose
    ~~~

3. app-server sunucusundan jenkins sunucusundaki docker registry'e erişebilmek aşağıdaki ayar girilirerek docker servisi restart edilir

    ~~~
    sudo nano /etc/docker/daemon.json
    ~~~
    ~~~
    {
    "insecure-registries":["jenkins:5000"]
    }
    ~~~
    ~~~
    sudo systemctl restart docker.service
    ~~~

4. /etc/hosts dosyasına jenkins sunucusunun IP adresi eklenir.    

5. Uygulama dizini oluşturulur
    ~~~
    sudo mkdir /opt/cihanca-devopz
    sudo setfacl -m u:jenkins:wx /opt/cihanca-devopz
    ~~~

6. http://jenkins:8080 adresinden Jenkins'in web arayüzüne girerek pipeline oluşturarak "Pipeline script from SCM / Repository URL" kısmına bu git repository'nin adresi yazılır (https://github.com/osmanizbat/cihanca-devopz)

7. Pipeline çalıştırıldıktan sonra app-server'da ilgili containerların çalışıp çalışmadığı kontrol edilir.  
    ~~~
    docker ps
    docker logs cihanca-devopz_user-management_1 -f
    docker logs cihanca-devopz_adopt-service_1 -f
    ~~~

8. Web tarayıcıda http://app-server:8080 adresi açılarak uygulamaya erişilir.
