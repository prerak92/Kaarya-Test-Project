Kaarya-Test-Project
===================

Sir,
I have implemented the case 1,2 and 3, but due to lack of time was unable to work on case 4 and 5
of broadcasting and unicasting messages.
For the implementation of Message Sending, I am assuming we are connected to a network and we
have a list of members and their respective addresses just as we have a list of members in the
current API.
On clicking the Name of the specific person, currently a toast is displayed but this can be used for
unicasting the message.
OnItemClick method can be used for the same. As the user clicks a new Activity is started and this
method passes the id of the item clicked through bundle and a string.
In this new Activity class we can find the address of the id given and acordingly the message can be
sent.
For Broadcasting the message we can have a field on the top of the list, which on clicking will send
call another Activity which will accept the message to be broadcasted and will send to all the
addresses stored in ArrayList, sequentially.
A new socket can be created through classes ServerSocket and Socket and accordingly an output
Stream and an InputStream can be established, through which the message or a string can be sent
and recieved.
Thanking You