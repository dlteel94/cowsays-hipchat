# cowsay-hipchat-integration
A hipchat integration for formatting text with the class cowsay package.  It also includes functionality to format cookies from the classic fortune package with cowsay.

## Deploy Status
[![Heroku](https://heroku-badge.herokuapp.com/?app=cowsays-integration?root=descriptor)]

## Installing on Hipchat
To get the master branch version, add the integration on the room level in Hipchat with the descriptor URL https://cowsays-integration.herokuapp.com/descriptor.  This is currently hosted on a free Heroku instance, so it may need to wake up when receiving the first command in a while.  If you do not receive a response, try to issue your command a few seconds later.

## Commands
### /cowsay -f
Get a fortune in cowsay format

### /cowsay <any_other_text>
Get a cowsay with the <any_other_text>

### /cowsay -h
(Coming soon)
Get help text that explains each command and how to use it.  Check this command regularly to learn about new features.

