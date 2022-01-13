import re, smtplib, ssl
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
def validateEmail(input):
    rgx = '^[a-z0-9]+[\._]?[a-z0-9]+[@]\w+[.]\w{2,3}$'
    return re.search(rgx, input)

def validatePhone(input):
    rgx= '\w{3}-\w{3}-\w{4}'
    return re.search(rgx, input)

def sendEmail(email, context):
    clubEmail = 'cyberdefnotifs@gmail.com'
    clubPassword = 'CyberDefNotifications'
    message = MIMEMultipart('alternative')
    message["Subject"] = 'CyberDefense Notification'
    message["From"] = 'cyberdefnotifs@gmail.com'
    message["To"] = email
    text = f"""\
    Hey! This is just a friendly notification:

    {context}

    Sincerely,
    Cyber Defense Club Management
    """
    html = f"""\
    <html>
        <body>
            <p>Hey!<br>
            This is just a friendly notification:<br>
            <h1>{context}</h1>
            <br><br>
            Sincerely,<br>
            Cyber Defense Club Management</p>
        </body>
    </html>
    """
    message.attach(MIMEText(html, "html"))

    with smtplib.SMTP_SSL("smtp.gmail.com", 465, context=ssl.create_default_context()) as server:
        server.login(clubEmail, clubPassword)
        server.sendmail(clubEmail, email, message.as_string())

#def sendText(phone, context):
# We didn't want to spend money on an SMS API, so we didn't. It would be trivially easy to
# implement it here using this, though.

def sendNotification(input, context):
    if validateEmail(input):
        sendEmail(input, context)
    else:
        print("invalid email LOL ")
    #else validatePhone(input):
        #sendText(input, context)

#sendNotification(input("email pls "), "fuck you")
