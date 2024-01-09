# BBK_MScProject - APPENDIX 2

A Graph-Based Database Application for Cartel Investigations:

This document contains a description of what the dummy database should contain, and several information about nodes, properties and relationships.

## * The Case *

The database is loosely based on a price-fixing case involving online sellers that offered their products through Amazon's UK website. The cartelists agreed to use a pricing software with the object to avoid undercutting each others prices.

CMA's notes on the case:
https://www.gov.uk/government/case-studies/online-sellers-price-fixing-case-study . 

As I happen to be an amateur boxing aficionado, this fictional case will involve boxing accessories.

## Nodes

 i) Firm: 
 
	 The DB will have 3 fictional firms (Labels)
	 1. PunchGear Co.
	 2. K.O. Inc.
	 3. TysonJab Ltd.

ii) Person:

	Every person that might be relevant to the conduct, such as business executives at different levels of hierarchy, labelled as "CEO", "Sales VP", "Zone Manager", "Sales Agent". For simplicity, we will assume all three firms follow the same organisational structure.

iv) Social Media Accounts (SMA)

	Given that a specific user can use plenty of SMAs, I will represent them as individual nodes, whereas email and phone numbers will be recorded as properties or Person.  

iii) Email

	This node will group email communications.

	 For this prototype, I have decided to represent every single Email, Message and Call as an individual node, to offer more granularity to the database. This will allow teams to assign a "weight" to individual messages, which will be useful when working with algorithms.

iv) Message

	-This will group all messages on apps that allow private, one-to-one or group messaging or calling, usually offering some level of encryption (Whatsapp, Telegram, Signal).

v) Call

	 -This node will gather information on individual or group calls made through the telephone line or through any platform or app.
	 We will assume that the agency has access to information on the existence of the calls sent/received by the relevant subjects, but not on the content (no phone tapping). This is the common case as new technologies makes easy access to voice call encryption.

vi) GroupChat

	- The widespread use of group messaging dynamics is especially relevant in the context of finding evidence of a cartel. This node will record the group of group-chat messaging (participants / content). 

vi) Meeting:

	-Node that represent information about in/person meetings with 2 or more individuals participating, either from the same organization (intra-company) or belonging to competing firms.


vi) Product

	- The following are the products for sale:
		- Boxing gloves
		- Hand wraps
		- Skipping ropes
		- Punching bags
		- Mouth Guards
	

		 This node is relevant to oour schema because we want to register individual sales, and find correlations between potential price fluctuations and communications between executives.
		 
		 * We will assume every firm sells every product, with the exception of TysonJab Ltd., that only sells boxing gloves, hand wraps and punching bags. We assume firms sell their own products only, which will be represented as distinct SKUs.
		
		


## Properties

###  i) Firm
	- Name
	

### ii) Person
	- Name
	- Surname
	- Age
	- Role
	- email_account
	- phone_number


### iii) Social Media Account (SMA)
	- Platform
	- Username
	- date_created
	- last_activity


### iii) Email
	- date
	- time
	- sender_address
	- receiver_address
	- Weight *
	- Flag ** ("meetings", "pricing", "agreement", "other")
	- link to content ***

	 * Investigative teams will be allowed to assign weight to individual messages based on  their importance to the case (evidentiary value), from 1 to 10, being 10 the most valuable.
	 
	** Additionaly, a "flag" can be added to give access to a brief description of the content of an email or message. Investigative teams may define several flags. For this database we will use four simple flags.
	
	*** Each node corresponding to an email or a message will showcase links to the message or email in plain text. I only will add links to some of them on the dummy database to exemplify the functionality. 


### iv) Call
	- medium ("phone line, whatsapp, skype)
	- date
	- time
	- duration


### v) GroupChat
	- name
	- platform
	- date_created

### vi) Message

	- platform (whatsapp, Telegram, Signal, Other).
	- date
	- time
	- format (text, image, audio, other)
	- Weight
	- Flag
	- link to content
	 

### vii) Meeting
	- date
	- time
	- category (in person/virtual)
	- location (if applicable)
	- platform (if applicable)
	- Weight

	
### viii) Product
	- product name
	- SKU (unique 7-digit random number per product)
	- Category: [Boxing gloves, Hand wraps, Skipping ropes, Punching bags, Mouth Guards]



## Relationships

a) Person -- [:WORKS]--> Firm : Represent affiliation or employment


		- PROPERTIES of the relation:
			i) since: Date employment or affiliation.
			ii) role 
			

b) Person -- [:MANAGES]--> Person : Represents hierarchy between two persons inside an organisation.


c) Person--[: HAS_ACCOUNT]-->SMA  : Links a person with their social media account (SMA).

d) SMA--[: FOLLOWS]-->SMA  : Links a SMA that follows (or 'is friends' with another).It can be bidirectional.


e) SMA--[: INTERACTED]-->SMA  : Links an action taken on a social media account (SMA) with another.

	- PROPERTIES of the relation:
			i) date
			ii) category: ("like", "retweet").

		* Note: Direct Messages (DMs) or comments will be considered "Messages" and not included in this category.	

f) SMA --[: SENT_DM]--> Message  : Represents a direct message sent  by a person using a SMA.


g) SMA --[: RECEIVED_DM]--> Message  : Represents a  direct message received by a SMA.


h) Email --[: SENT_EMAIL]--> Email  : Represents an electronic mail sent from one email account to another.

		* Note: We only link the email accounts as SENDER/RECEIVER, not a person with an email. email_address is a property of Person, and one person usually uses one or two email addresses, as opposed to social media accounts (that could be plenty). Hence I consider that adding another relation could needlessly complicate the analysis.
		

i) Email --[: RECEIVED_EMAIL]--> Email  : Represents an electronic mail received from one account from another.

j) Person --[: PARTICIPATED_IN]--> GroupChat  : Links a person with a groupChat.


k) Person --[: SENT_MSG]--> Message  : Represents a message sent by a Person (througn Whatsapp, Signal, Telegram or other non-SMA platforms).


l) Person --[: RECEIVED_MSG]--> Message  : Represents a  message received by a Person (througn Whatsapp, Signal, Telegram or other non-SMA platforms)..
	 
m) Message --[: IN]--> GroupChat  : Links a message to a GroupChat


n) Person)-[:MADE_CALL]->Call: Links a person with a specific voice call.


o) Person)-[:RECEIVED_CALL]->Call: Person that received a voice call.


p) Person-[:ATTENDED]-> Meeting : Links a person with a meeting.

q) Firm --[:SOLD]--> Product: Represets a firm that sold a specific product. 
As the investigation relates to sales made through Amazon, we will assume all sales incorporated in this DB were made through that specific platform.
 
	  - PROPERTIES of the relation:
			i) date sold
			ii) timestamp
			iii) quantity
			iv) price per unit (PPU), in £.
			
			
			








