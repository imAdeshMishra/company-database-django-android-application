from django.http import HttpResponse, JsonResponse

def home_page(request):
    print("Welcome to home")
    freinds = [
        'adesh',
        'abhishek',
        'abhay'
    ]
    return JsonResponse(freinds,safe=False)