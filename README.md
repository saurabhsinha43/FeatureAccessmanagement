# FeatureAccessmanagement
Check if a user has the access for given feature and update data for the same

Hi,

Saurabh here! I created a spring boot application and two rest Api.
GET  /feature?email=XXX&featureName=XXX : It takes two input parameter, email and featureName and returns whether the user has access for this feature or not.

POST /feature : It takes featureName, email and enable value is JSON format and saves it to the database.
