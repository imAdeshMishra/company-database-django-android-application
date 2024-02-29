from django.contrib import admin
from api_app.models import Company, Employee
# Register your models here.


class CompanyAdmin(admin.ModelAdmin):
    list_display = ('name','location','type')

admin.site.register(Company,CompanyAdmin)
admin.site.register(Employee)
