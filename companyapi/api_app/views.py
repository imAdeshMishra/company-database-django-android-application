from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.decorators import action
from rest_framework.response import Response

from api_app.models import Company,Employee
from api_app.serializers import CompanySerializers, EmployeeSerializers
# Create your views here.

class CompanyViewSet(viewsets.ModelViewSet):
    queryset = Company.objects.all()
    serializer_class = CompanySerializers

    @action(detail=True,methods=['get'])
    def employees(self,request,pk=None):
        print("get employees of" ,pk, "company")
        try:
            company= Company.objects.get(pk=pk)
            emps=Employee.objects.filter(company=company)
            emps_serializer = EmployeeSerializers(emps,many=True,context={'request':request})

            return Response(emps_serializer.data)
        except Exception as e:
            print(e)
            print("hihihahahaha")
            return Response({
                'message': 'company  might not exist'
            })


class EmployeeViewSet(viewsets.ModelViewSet):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializers