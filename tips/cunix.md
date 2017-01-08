# How to Connect to CUNIX

### Basic:
- Run the following command to connect to CUNIX:

		ssh uni@cunix.columbia.edu

- For example:

		ssh ea2678@cunix.columbia.edu


### Troubleshooting:

##### No matching host key
- Error: `Unable to negotiate with 128.59.92.136 port 22: no matching host key 
type found. Their offer: ssh-dss`
- To resolve this, edit one of your ssh config files.
- Type the following command in the terminal:

		pico ~/.ssh/config

- This will open a blank file. Add this text to the file:

		Host cunix.columbia.edu
    		HostkeyAlgorithms +ssh-dss

- Save and exit, and try connecting to cunix again.
- As an alternative, you can also try connecting with the following command:

		ssh -oHostKeyAlgorithms=+ssh-dss uni@cunix.columbia.edu
