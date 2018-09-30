## Continuous Integration and Continuous Deployment (CI/CD)
### Automate Workflows for Software Development and Deployment
Docker containers support CI/CD implementation by allowing developers to build code collaboratively through the sharing of images while simplifying deployment to different infrastructure. With Docker Enterprise, you can build a DevOps practice that integrates with your choice of CI tools, any application stack, running on Linux or Windows, on any infrastructure--on-premises, in the cloud, or both. 


## What is a Container
##### Package Software into Standardized Units for Development, Shipment and Deployment.<br>
A Docker container image is a lightweight, standalone, executable package of software that includes everything needed to run an application: code, runtime, system tools, system libraries and settings.<br>
Container images become containers at runtime and in the case of Docker containers - images become containers when they run on Docker Engine. Available for both Linux and Windows-based applications, containerized software will always run the same, regardless of the infrastructure. Containers isolate software from its environment and ensure that it works uniformly despite differences for instance between development and staging. <br>
* Standard: Docker created the industry standard for containers, so they could be portable anywhere
* Lightweight: Containers share the machine’s OS system kernel and therefore do not require an OS per application, driving higher server efficiencies and reducing server and licensing costs
* Secure: Applications are safer in containers and Docker provides the strongest default isolation capabilities in the industry

##### Docker Containers Are Everywhere: Linux, Windows, Data center, Cloud, Serverless, etc.


##### Comparing Containers and Virtual Machines
Containers and virtual machines have similar resource isolation and allocation benefits, but function differently because containers virtualize the operating system instead of hardware. Containers are more portable and efficient.
* Containers are an abstraction at the app layer that packages code and dependencies together. Multiple containers can run on the same machine and share the OS kernel with other containers, each running as isolated processes in user space. Containers take up less space than VMs (container images are typically tens of MBs in size), can handle more applications and require fewer VMs and Operating systems. 
* Virtual machines (VMs) are an abstraction of physical hardware turning one server into many servers. The hypervisor allows multiple VMs to run on a single machine. Each VM includes a full copy of an operating system, the application, necessary binaries and libraries - taking up tens of GBs. VMs can also be slow to boot.


##### Container Standards and Industry Leadership
Docker developed a Linux container technology - one that is portable, flexible and easy to deploy. Docker open sourced libcontainer and partnered with a worldwide community of contributors to further its development. In June 2015, Docker donated the container image specification and runtime code now known as runc, to the Open Container Initiative (OCI) to help establish standardization as the container ecosystem grows and matures.

## why-docker
Docker Containerization Unlocks the Potential for Dev and Ops.Freedom of choice, agile operations and integrated container security for legacy and cloud-native applications.

##### A Modern Platform for All Applications
Docker unlocks the potential of your organization by giving developers and IT the freedom to build, manage and secure business-critical applications without the fear of technology or infrastructure lock-in.
By combining its industry-leading container engine technology, an enterprise-grade container platform and world-class services, Docker enables you to bring traditional and cloud native applications built on Windows Server, Linux and mainframe into an automated and secure supply chain, advancing dev to ops collaboration and reducing time to value.
Because Docker increases productivity and reduces the time it takes to bring applications to market, you now have the resources needed to invest in key digitization projects that cut across the entire value chain, such as application modernization, cloud migration and server consolidation. With Docker, you have the solution that helps you manage the diverse applications, clouds and infrastructure you have today while providing your business a path forward to future applications.

##### What Docker Can Do For Your Business
The Docker Enterprise container platform delivers immediate value to your business by reducing the infrastructure and maintenance costs of supporting your existing application portfolio while accelerating your time to market for new solutions. 

# get start

## set up
### install
https://docs.docker.com/install/linux/docker-ce/centos/

https://docs.docker.com/install/linux/docker-ce/ubuntu/x

### Post-installation steps for Linux
The Docker daemon binds to a Unix socket instead of a TCP port. By default that Unix socket is owned by the user root and other users can only access it using sudo. The Docker daemon always runs as the root user.

If you don’t want to preface the docker command with sudo, create a Unix group called docker and add users to it. When the Docker daemon starts, it creates a Unix socket accessible by members of the docker group.

* Create the docker group.

```shell
sudo groupadd docker

```
* Add your user to the docker group.

```shell
sudo usermod -aG docker vobile

```
* Log out and log back in so that your group membership is re-evaluated.
* Verify that you can run docker commands without sudo.

```shell
$ docker run hello-world
```
This command downloads a test image and runs it in a container. When the container runs, it prints an informational message and exits.

If you initially ran Docker CLI commands using sudo before adding your user to the docker group, you may see the following error, which indicates that your ~/.docker/ directory was created with incorrect permissions due to the sudo commands.

```shell
WARNING: Error loading config file: /home/user/.docker/config.json -
stat /home/user/.docker/config.json: permission denied

```
To fix this problem, either remove the ~/.docker/ directory (it is recreated automatically, but any custom settings are lost), or change its ownership and permissions using the following commands:

```shell
$ sudo chown "$USER":"$USER" /home/"$USER"/.docker -R
$ sudo chmod g+rwx "$HOME/.docker" -R

```
#### Configure Docker to start on boot
Most current Linux distributions (RHEL, CentOS, Fedora, Ubuntu 16.04 and higher) use systemd to manage which services start when the system boots. Ubuntu 14.10 and below use upstart.

```
systemd
```

```shell
$ sudo systemctl enable docker

```
To disable this behavior, use disable instead.

```shell
$ sudo systemctl disable docker

```

### Control Docker with systemd
Many Linux distributions use systemd to start the Docker daemon. This document shows a few examples of how to customize Docker’s settings.

#### Start the Docker daemon
##### Start manually
Once Docker is installed, you need to start the Docker daemon. Most Linux distributions use systemctl to start services. If you do not have systemctl, use the service command.
* systemctl

```
$ sudo systemctl start docker

```
* service

```
$ sudo service docker start

```
#### Custom Docker daemon options
There are a number of ways to configure the daemon flags and environment variables for your Docker daemon. The recommended way is to use the platform-independent daemon.json file, which is located in /etc/docker/ on Linux by default. See Daemon configuration file.

You can configure nearly all daemon configuration options using daemon.json. The following example configures two options. One thing you cannot configure using daemon.json mechanism is a HTTP proxy.
	


## Get Started, Part 1: Orientation and setup
### docker concepts
Docker is a platform for developers and sysadmins to develop, deploy, and run applications with containers. The use of Linux containers to deploy applications is called containerization. Containers are not new, but their use for easily deploying applications is.<br>
Containerization is increasingly popular because containers are:<br>
* Flexible: Even the most complex applications can be containerized.
* Lightweight: Containers leverage and share the host kernel.
* Interchangeable: You can deploy updates and upgrades on-the-fly.
* Portable: You can build locally, deploy to the cloud, and run anywhere.
* Scalable: You can increase and automatically distribute container replicas.
* Stackable: You can stack services vertically and on-the-fly.

#### Images and containers
A container is launched by running an image. An image is an executable package that includes everything needed to run an application--the code, a runtime, libraries, environment variables, and configuration files.<br>
A container is a runtime instance of an image--what the image becomes in memory when executed (that is, an image with state, or a user process). You can see a list of your running containers with the command, docker ps, just as you would in Linux.<br>

#### Containers and virtual machines
A container runs natively on Linux and shares the kernel of the host machine with other containers. It runs a discrete process, taking no more memory than any other executable, making it lightweight.
By contrast, a virtual machine (VM) runs a full-blown “guest” operating system with virtual access to host resources through a hypervisor. In general, VMs provide an environment with more resources than most applications need.

#### Prepare your Docker environment
1. install

##### Test Docker version
Run docker --version  and ensure that you have a supported version of Docker:<br>
Run docker info or (docker version without --) to view even more details about your docker installation:<br>

##### Test Docker installation
Test that your installation works by running the simple Docker image, hello-world:

```
docker run hello-world

Unable to find image 'hello-world:latest' locally
latest: Pulling from library/hello-world
ca4f61b1923c: Pull complete
Digest: sha256:ca0eeb6fb05351dfc8759c20733c91def84cb8007aa89a5bf606bc8b315b9fc7
Status: Downloaded newer image for hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.
...
```
List the hello-world image that was downloaded to your machine:

```
$ docker image ls

```

#### Recap and cheat sheet

```
## List Docker CLI commands
docker
docker container --help

## Display Docker version and info
docker --version
docker version
docker info

## Execute Docker image
docker run hello-world

## List Docker images
docker image ls

## List Docker containers (running, all, all in quiet mode)
docker container ls
docker container ls --all
docker container ls -aq
	
```

### Conclusion of part one
Containerization makes CI/CD seamless.

* applications have no system dependencies
* updates can be pushed to any part of a distributed application
* resource density can be optimized.

## Get Started, Part 2: Containers
### Introduction
It’s time to begin building an app the Docker way. We start at the bottom of the hierarchy of such an app, which is a container, which we cover on this page. Above this level is a service, which defines how containers behave in production, covered in Part 3. Finally, at the top level is the stack, defining the interactions of all the services, covered in Part 5.
> * Stack
  * Services
  * Container

### Your new development environment
In the past, if you were to start writing a Python app, your first order of business was to install a Python runtime onto your machine. But, that creates a situation where the environment on your machine needs to be perfect for your app to run as expected, and also needs to match your production environment.

With Docker, you can just grab a portable Python runtime as an image, no installation necessary. Then, your build can include the base Python image right alongside your app code, ensuring that your app, its dependencies, and the runtime, all travel together.

These portable images are defined by something called a Dockerfile.

### Define a container with Dockerfile
Dockerfile defines what goes on in the environment inside your container. Access to resources like networking interfaces and disk drives is virtualized inside this environment, which is isolated from the rest of your system, so you need to map ports to the outside world, and be specific about what files you want to “copy in” to that environment. However, after doing that, you can expect that the build of your app defined in this Dockerfile behaves exactly the same wherever it runs.

**Dockerfile**
Create an empty directory. Change directories (cd) into the new directory, create a file called Dockerfile, copy-and-paste the following content into that file, and save it. Take note of the comments that explain each statement in your new Dockerfile.

```
# Use an official Python runtime as a parent image
FROM python:2.7-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages specified in requirements.txt
RUN pip install --trusted-host pypi.python.org -r requirements.txt

# Make port 80 available to the world outside this container
EXPOSE 80

# Define environment variable
ENV NAME World

# Run app.py when the container launches
CMD ["python", "app.py"]

```
This Dockerfile refers to a couple of files we haven’t created yet, namely app.py and requirements.txt. Let’s create those next.

### The app itself ###
Create two more files, requirements.txt and app.py, and put them in the same folder with the Dockerfile. This completes our app, which as you can see is quite simple. When the above Dockerfile is built into an image, app.py and requirements.txt is present because of that Dockerfile’s COPY command, and the output from app.py is accessible over HTTP thanks to the EXPOSE command.

**requirements.txt**

```
Flask
Redis
```
**app.py**

```
from flask import Flask
from redis import Redis, RedisError
import os
import socket

# Connect to Redis
redis = Redis(host="redis", db=0, socket_connect_timeout=2, socket_timeout=2)

app = Flask(__name__)

@app.route("/")
def hello():
    try:
        visits = redis.incr("counter")
    except RedisError:
        visits = "<i>cannot connect to Redis, counter disabled</i>"

    html = "<h3>Hello {name}!</h3>" \
           "<b>Hostname:</b> {hostname}<br/>" \
           "<b>Visits:</b> {visits}"
    return html.format(name=os.getenv("NAME", "world"), hostname=socket.gethostname(), visits=visits)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=80)

```

Now we see that pip install -r requirements.txt installs the Flask and Redis libraries for Python, and the app prints the environment variable NAME, as well as the output of a call to socket.gethostname(). Finally, because Redis isn’t running (as we’ve only installed the Python library, and not Redis itself), we should expect that the attempt to use it here fails and produces the error message.

>Note: Accessing the name of the host when inside a container retrieves the container ID, which is like the process ID for a running executable.

That’s it! You don’t need Python or anything in requirements.txt on your system, nor does building or running this image install them on your system. It doesn’t seem like you’ve really set up an environment with Python and Flask, but you have.


### Build the app ###
We are ready to build the app. Make sure you are still at the top level of your new directory. Here’s what ls should show:

```
$ ls
Dockerfile		app.py			requirements.txt
```

Now run the build command. This creates a Docker image, which we’re going to tag using -t so it has a friendly name.

```
docker build -t friendlyhello .
```
Where is your built image? It’s in your machine’s local Docker image registry:

```
$ docker image ls

REPOSITORY            TAG                 IMAGE ID
friendlyhello         latest              326387cea398
```

>__Proxy server settings__
Proxy servers can block connections to your web app once it’s up and running. If you are behind a proxy server, add the following lines to your Dockerfile, using the ENV command to specify the host and port for your proxy servers:

```
# Set proxy server, replace host:port with values for your servers
ENV http_proxy host:port
ENV https_proxy host:port

```
>__DNS settings__
DNS misconfigurations can generate problems with pip. You need to set your own DNS server address to make pip work properly. You might want to change the DNS settings of the Docker daemon. You can edit (or create) the configuration file at /etc/docker/daemon.json with the dns key, as following:

```
{
  "dns": ["your_dns_address", "8.8.8.8"]
}

```
In the example above, the first element of the list is the address of your DNS server. The second item is the Google’s DNS which can be used when the first one is not available.

Before proceeding, save daemon.json and restart the docker service.

```
sudo service docker restart
```
Once fixed, retry to run the build command.

### Run the app ###
Run the app, mapping your machine’s port 4000 to the container’s published port 80 using -p:

```
docker run -p 4000:80 friendlyhello
```
You should see a message that Python is serving your app at http://0.0.0.0:80. But that message is coming from inside the container, which doesn’t know you mapped port 80 of that container to 4000, making the correct URL http://localhost:4000.

This port remapping of 4000:80 demonstrates the difference between EXPOSE within the Dockerfile and what the publish value is set to when running docker run -p. In later steps, map port 4000 on the host to port 80 in the container and use http://localhost.

Now let’s run the app in the background, in detached mode:

```
docker run -d -p 4000:80 friendlyhello
```
You get the long container ID for your app and then are kicked back to your terminal. Your container is running in the background. You can also see the abbreviated container ID with docker container ls (and both work interchangeably when running commands):

```
$ docker container ls
CONTAINER ID        IMAGE               COMMAND             CREATED
1fa4ab2cf395        friendlyhello       "python app.py"     28 seconds ago
```
Notice that CONTAINER ID matches what’s on http://localhost:4000.
Now use docker container stop to end the process, using the CONTAINER ID, like so:

```
docker container stop 1fa4ab2cf395
```
### Share your image
To demonstrate the portability of what we just created, let’s upload our built image and run it somewhere else. After all, you need to know how to push to registries when you want to deploy containers to production.

A registry is a collection of repositories, and a repository is a collection of images—sort of like a GitHub repository, except the code is already built. An account on a registry can create many repositories. The docker CLI uses Docker’s public registry by default.

### Log in with your Docker ID
If you don’t have a Docker account, sign up for one at hub.docker.com. Make note of your username.

Log in to the Docker public registry on your local machine.

```
$ docker login
```

### Tag the image
The notation for associating a local image with a repository on a registry is username/repository:tag. The tag is optional, but recommended, since it is the mechanism that registries use to give Docker images a version. Give the repository and tag meaningful names for the context, such as get-started:part2. This puts the image in the get-started repository and tag it as part2.

Now, put it all together to tag the image. Run docker tag image with your username, repository, and tag names so that the image uploads to your desired destination. The syntax of the command is:

```
docker tag image username/repository:tag	
```
For example:

```
docker tag friendlyhello gordon/get-started:part2
```
Run docker image ls to see your newly tagged image.

```
$ docker image ls
REPOSITORY           TAG                 IMAGE ID            CREATED             SIZE
gordon/get-started   part2               209011d151af        11 hours ago        132MB
friendlyhello        latest              209011d151af        11 hours ago        132MB
ubuntu               latest              cd6d8154f1e1        3 weeks ago         84.1MB
python               2.7-slim            c9cde4658340        3 weeks ago         120MB
hello-world          latest              e38bc07ac18e        5 months ago        1.85kB
```

### Publish the image
Upload your tagged image to the repository:

```
docker push username/repository:tag
```
Once complete, the results of this upload are publicly available. If you log in to Docker Hub, you see the new image there, with its pull command.

### Pull and run the image from the remote repository
From now on, you can use docker run and run your app on any machine with this command:

```
docker run -p 4000:80 username/repository:tag
```
If the image isn’t available locally on the machine, Docker pulls it from the repository.

我先把新建的image给删除

```
docker image rm -f 209011d151af
```
If the image isn’t available locally on the machine, Docker pulls it from the repository.

```
vobile@vobile-ThinkPad-X1-Carbon-2nd:~$ docker run -p 4000:80 zjhgx/get-started:part2
WARNING: Error loading config file: /home/vobile/.docker/config.json: stat /home/vobile/.docker/config.json: permission denied
Unable to find image 'zjhgx/get-started:part2' locally
part2: Pulling from zjhgx/get-started
802b00ed6f79: Already exists 
10b2d5f7ed73: Already exists 
1073a127cf89: Already exists 
90283f3dc1cd: Already exists 
5b9089a76fb5: Already exists 
88fc08329b9d: Already exists 
83897ed5dc51: Already exists 
Digest: sha256:79174156581c739621667f1b76c09fb5e518add054a3690289312f87c8dc560a
Status: Downloaded newer image for zjhgx/get-started:part2
 * Serving Flask app "app" (lazy loading)
 * Environment: production
   WARNING: Do not use the development server in a production environment.
   Use a production WSGI server instead.
 * Debug mode: off
 * Running on http://0.0.0.0:80/ (Press CTRL+C to quit)
```
No matter where docker run executes, it pulls your image, along with Python and all the dependencies from requirements.txt, and runs your code. It all travels together in a neat little package, and you don’t need to install anything on the host machine for Docker to run it.

Here is a list of the basic Docker commands from this page, and some related ones if you’d like to explore a bit before moving on.

```
docker build -t friendlyhello .  # Create image using this directory's Dockerfile
docker run -p 4000:80 friendlyhello  # Run "friendlyname" mapping port 4000 to 80
docker run -d -p 4000:80 friendlyhello         # Same thing, but in detached mode
docker container ls                                # List all running containers
docker container ls -a             # List all containers, even those not running
docker container stop <hash>           # Gracefully stop the specified container
docker container kill <hash>         # Force shutdown of the specified container
docker container rm <hash>        # Remove specified container from this machine
docker container rm $(docker container ls -a -q)         # Remove all containers
docker image ls -a                             # List all images on this machine
docker image rm <image id>            # Remove specified image from this machine
docker image rm $(docker image ls -a -q)   # Remove all images from this machine
docker login             # Log in this CLI session using your Docker credentials
docker tag <image> username/repository:tag  # Tag <image> for upload to registry
docker push username/repository:tag            # Upload tagged image to registry
docker run username/repository:tag                   # Run image from a registry

```

## Get Started, Part 3: Services

### Prerequisites

 * Get Docker Compose
 
 ```
curl -L https://github.com/docker/compose/releases/download/1.22.0/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
 ```
 
### Introduction
In part 3, we scale our application and enable load-balancing. To do this, we must go one level up in the hierarchy of a distributed application: the service.






