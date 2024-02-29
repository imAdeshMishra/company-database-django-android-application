from django.db import models


# Create your models here.

class Company(models.Model):
    company_id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=50)
    location = models.CharField(max_length=50)
    about = models.TextField()
    type = models.CharField(max_length=100, choices=(('IT', 'IT'),
                                                     ('NON IT', 'NON IT'),
                                                     ('MOBILE PHONES', 'MOBILE PHONES')
                                                     ))
    added_date = models.DateTimeField(auto_now=True)
    active = models.BooleanField(default=True)

    def __str__(self):
        return self.name + '-' + self.location


class Employee(models.Model):
    employee_name = models.CharField(max_length=50)
    email_id = models.CharField(max_length=50)
    address = models.CharField(max_length=50)
    phone_number = models.CharField(max_length=10)
    age = models.IntegerField()
    position = models.CharField(max_length=10)
    position = models.CharField(max_length=50, choices=(
        ('Manager', 'manager'),
        ('Software Developer', 'sd'),
        ('Human Resource', 'hr'),
        ('Finance', 'finance'),
    ))
    company = models.ForeignKey(Company, on_delete=models.CASCADE)
