from django import template
register = template.Library()

@register.filter
def dumbWorkaround(indexable,i):
    return indexable[i].image.url
