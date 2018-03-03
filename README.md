# Say Sorry

> send apology text message to your near and dear ones using [MSG91 API](https://msg91.com/), with collection of over 150 sorry messages collected from Internet.

[![Issues](https://camo.githubusercontent.com/926d8ca67df15de5bd1abac234c0603d94f66c00/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f636f6e747269627574696f6e732d77656c636f6d652d627269676874677265656e2e7376673f7374796c653d666c6174)](https://github.com/amarlearning/Github-Sectory/issues)
[![MIT LICENSE](https://img.shields.io/pypi/l/pyzipcode-cli.svg)](http://amarlearning.mit-license.org/)


## Install
```
git clone https://github.com/amarlearning/say-sorry.git
```
once the repository is cloned successfully, the open eclipse and follow below steps:
```
File > Import > Existing Maven Project
```
then give the path to ```pom.xml``` file present in the project and click ```finish```.


## Usage

In order to use this program you need to have an auth key which you can get by making an account on [MSG91 API](https://msg91.com/) website.

Lets talk about the params that you should know before running this program

| Parameter  | Description |
| ------------- | ------------- |
| mainUrl  |  Base Url of MSG91 ([http://api.msg91.com/api/sendhttp.php?](http://api.msg91.com/api/sendhttp.php?)) |
| authkey  | Login authentication key (this key is unique for every user)  |
| mobiles  | Keep numbers in National format (without country code), multiple numbers should be separated by comma (,)  |
| senderId  | Receiver will see this as sender's ID. [More Read](https://help.msg91.com/article/40-what-is-a-sender-id-how-to-select-a-sender-id)  |
| route  | If your operator supports multiple routes then give one route name. Eg: route=1 for promotional, route=4 for transactional SMS. [More Read](https://help.msg91.com/article/64-what-is-the-difference-between-transactional-promotional-and-sendotp-route)  |
| country  | 0 for international,1 for USA, 91 for India.  |

What to know more about MSG91 API? [Link](https://docs.msg91.com/collection/msg91-api-integration/5/pages/139).

## Issues

You can report the bugs at the [issue tracker](https://github.com/amarlearning/say-sorry/issues)

**OR**

You can [tweet me](https://twitter.com/iamarpandey) if you can't get it to work. In fact, you should tweet me anyway.

***

## License

Built with ♥ by Amar Prakash Pandey([@amarlearning](http://github.com/amarlearning)) under [MIT License](http://amarlearning.mit-license.org/) 

You can find a copy of the License at http://amarlearning.mit-license.org/
