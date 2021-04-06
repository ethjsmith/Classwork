from django import template
register = template.Library()

@register.filter
def index(u):
    try: # lmfao 
        if u.member.permission > 0:
            return True
        return False
    except:
        return False
