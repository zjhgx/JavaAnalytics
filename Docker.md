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
Now we see that pip install -r requirements.txt installs the Flask and Redis libraries for Python, and the app prints the environment variable NAME, as well as the output of a call to socket.gethostname(). Finally, because Redis isn’t running (as we’ve only installed the Python library, and not Redis itself), we should expect that the attempt to use it here fails and produces the error message.

>Note: Accessing the name of the host when inside a container retrieves the container ID, which is like the process ID for a running executable.

That’s it! You don’t need Python or anything in requirements.txt on your system, nor does building or running this image install them on your system. It doesn’t seem like you’ve really set up an environment with Python and Flask, but you have.



