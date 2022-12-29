# Jenkins sunucusuna Docker kurulumu

~~~
sudo apt install docker.io
sudo docker run --rm hello-world
sudo usermod -aG docker $USER
sudo usermod -aG docker jenkins
~~~

- Docker registtry kurulumu
~~~
docker run -d -p 5000:5000 --restart=always --name registry registry:2
~~~

# app-server sunucusuna Docker kurulumu

~~~
sudo apt install docker.io docker-compose
sudo docker run --rm hello-world
~~~

- /etc/docker/daemon.json dosyasına aşağıdaki ayar girilir
~~~
{
 "insecure-registries":["jenkins:5000"]
}
~~~
