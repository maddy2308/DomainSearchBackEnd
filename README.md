# DomainSearchBackEnd

This is a SpringBoot application that acts as a service to fetch the closest list of domain names based on prefix matching. 
The core logic is implemented using TRIE DS. The list of domain names is read from a CSV file to mock the data. Ideally 
it would be good to have some other data store. The first time server spins up it takes time but then on it is very quick. 
The csv file has approx 1+ million records.
