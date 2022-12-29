# Jenkins sunucusuna Docker kurulumu

~~~
sudo apt install docker.io
sudo docker run --rm hello-world
sudo usermod -aG docker $USER
sudo usermod -aG docker jenkins
~~~

- Docker registtry kurulumu
~~~
 docker run -dit --restart unless-stopped --name registry registry:2
~~~

# app-server sunucusuna Docker kurulumu

~~~
sudo apt install docker.io docker-compose
sudo docker run --rm hello-world
sudo usermod -aG docker $USER
~~~


