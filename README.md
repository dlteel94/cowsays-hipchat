# cowsay-hipchat-integration
A hipchat integration for formatting text with the class cowsay package.  It also includes functionality to format cookies from the classic fortune package with cowsay.

## Deploy Status
// TODO: Add deploy status badge

## Contributing
We welcome contributions to this project.  To contribute, either find an issue marked pr-welcome, assign it to yourself, and then put up a pr for it, or create your own issue, assign it to yourself, then put up a PR for it into the **master** branch.

We also welcome PR Reviews.  PRs will need a certain amount of approvals before being merged.  This number will change as the number of active contributors change.  One of the approvals must be from a repo owner in order to be merged.  We will release production builds on Heroku at a regular schedule.  See the "Installing on Hipchat" for more info on installing the production integration in your Hipchat room.

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

#### Contributors
The following Github users have contributed to this project (with thier contributions making it to the master branch.  **You should add your Github username to this list at the end when subitting a PR if it is not already on the list.  Please maintain order.**
- dlteel94
