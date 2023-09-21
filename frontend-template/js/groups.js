function loadGrupsJS () {
    
    var dataTableGroups = null

    var groupId = null
    var arrGroupsId = []

    var arrGroups = []

    var flagDeleteMultiGroups = false
    
    var flagCreateNewGroup = false

    var currentRowIndex = 0

    function getListGroups(searchInput) {
        $.ajax({
            url: 'http://localhost:8686/api/groups/',
            method: 'GET',

            /* Basic authentication */
            beforeSend: function(xhr) {
                xhr.setRequestHeader('Authorization', 'Basic ' + btoa(localStorage.getItem('username') + ':' + localStorage.getItem('password')))
            },

            data: {
                search: searchInput,
                
            },
            success: function(response) {
                console.log(response)
                createTableGroups(response.content)//Create datatable department
            },
            error: function(error) {
                console.log(error)
            }
        })
    }

    getListGroups('');

    function createTableGroups(groups) {
        let groups = []
        for (let i = 0; i < groups.length; i ++) {
            let temp = []
            temp[0] = i + 1
            temp[1] = groups[i].name
            temp[2] = groups[i].totalMember
            temp[3] = listDepartments[i].createdAt
            temp[4] = groups[i].id
            temp[5] = ''
            temp[6] = '',
            groups.push(temp)
        }
        
        dataTableGroups = $('#table_groups').DataTable({
            'processing': true,
            data: departments,
            columns: [
                { title: 'Order'},
                { title: "Name"},
                { title: "Total Member"},
                { title: "Type"},
                { title: "Created Date"},
                { title: ''},
                { title: "Actions"},
                { title: "Select"},
            ],
            "columnDefs": [
                {
                    "targets": 5,
                    "visible": false
                },
                {
                    "targets": 6,
                    "width": 110,
                    "createdCell": function (td, cellData, rowData, row, col) {
                        $(td).css({
                            'text-align': 'left',
                            'display': 'flex'
                        });
                    },
                    "render": function(data, type, row, meta) {
                        return '<td>' +
                            '<button data-toggle="modal" data-target="#defaultModalWarning2" class="edit btn-modal"><i class="material-icons">&#xE254;</i></button>' +
                            '<button data-toggle="modal" data-target="#defaultModalDanger2" class="delete btn-modal"><i class="material-icons">&#xE872;</i></button>' +
                        '</td>'
                    }
                },
                {
                    orderable: false,
                    className: 'select-checkbox',
                    targets: 7,
                    width: 45
                },
            ],
            'select': {
                'style': 'multi'
            },
        })

        //Select multil department for deleting

        $('#datatables_departments tbody').on( 'click', 'tr', function () {
            let id = parseInt(dataTable.row(this).data()[5])
            arrDepartmentId.push(id)
        });
    }


    $('#btn_close_form_department').click(function() {
        dataTable.$('tr.selected').removeClass('selected');
    })

    $('#btn_dismiss_form_department').click(function() {
        dataTable.$('tr.selected').removeClass('selected');
    })

    $('#btn_no_department').click(function() {
        dataTable.$('tr.selected').removeClass('selected');
    })

    $('#btn_close_delete_department').click(function() {
        dataTable.$('tr.selected').removeClass('selected');
    })

    $('#btn_add_department').click(function(e) {
        flagCreateNewDepartment = true

        $('#department_name').val('')
        $('#department_type').val('')

        $('#div_add_accounts').hide()
    })

    $('#btn_save_department').click(function(e) {
        e.preventDefault()
        let department = {
            name: $('#department_name').val(),
            totalMember: arrAccounts.length,
            type: $('#department_type').val(),
            accounts: arrAccounts,
        }
        let urlAPI = ''
        let methodRequest = ''
        if (flagCreateNewDepartment == true) {
            methodRequest = 'POST'
            urlAPI = 'http://localhost:8888/api/departments/'
        }else {
            urlAPI = 'http://localhost:8888/api/departments/' + departmentId
            methodRequest = 'PUT'
        }
        $.ajax({
            url: urlAPI,
            method: methodRequest,
            contentType: 'application/json',
            dataType: 'json',

            /* Basic authentication */
            beforeSend: function(xhr) {
                xhr.setRequestHeader('Authorization', 'Basic ' + btoa(localStorage.getItem('username') + ':' + localStorage.getItem('password')))
            },

            data: JSON.stringify(department),

            success: function(data) {
                console.log(data)
                if (data.status == 200) {
                    if (flagCreateNewDepartment == true) {
                        console.log('insert successfully')

                         //Reset flag update
                        flagCreateNewDepartment = false;
                    }else {
                        console.log('update successfully')
                    }

                    clearArrAccounts()

                    dataTable.destroy()
                    getListDepartments('', '', '', '', PAGE_NUMBER, PAGE_SIZE, ORDER_BY)
                }

                $('#btn_dismiss_form_department').click()
            },
            error: function(request, status, error) {
                console.log(error)

                clearArrAccounts()
            }

        })

    })

    $('#btn_add_account_department').click(function(e) {
        e.preventDefault()

        $('#modal_add_account_department').modal()

        createTableListAccounts()
        clearArrAccounts()
    })

    $('#btn_close_add_account_department').click(function() {
        dataTableAccount.$('tr.selected').removeClass('selected');
        dataTableAccount.destroy()
        clearArrAccounts()
    })

    //Clear arrAccounts after delete multiple
    const clearArrAccounts = () => {
        while(arrAccounts.length > 0) {
            arrAccounts.pop()
        }
    }

    const clearArrDepartmentId = () => {
        while(arrDepartmentId.length > 0) {
            arrDepartmentId.pop()
        }
    }


    $('#btn_delete_multi_deparment').click(function() {
        if (arrDepartmentId.length == 0) alert('Mời bạn chọn department cần xóa')
        else {
            $('#defaultModalDanger2').modal()

            flagDeleteMultiDepartment = true
        }
    })

    $('#datatables_departments').on('click', 'td .edit', function (e) {
        e.preventDefault()
        flagCreateNewDepartment = false

        console.log('edit on table department...')

        $('#title_form_department').html('Edit Department')

        $('#div_add_accounts').hide()

        $('#btn_add_account_department').hide()

        currentRowIndex = parseInt( $(this).closest('tr').find('td').eq(0).html() ) - 1

        let rowData = dataTable.row(currentRowIndex).data()
        
        departmentId = rowData[5]

        $('#department_name').val(rowData[1])
        $('#department_type').val(rowData[3])

        //Tương tự phần account
    })

    $('#btn_add_department').click(function(e) {
        e.preventDefault()
        $('#title_form_department').html('Create New Department')
        $('#btn_add_account_department').show()
    })

    $('#datatables_departments').on('click', 'td .delete', function(e) {
        e.preventDefault()
        flagDeleteMultiDepartment = false

        //$('#defaultModalDanger2').modal()

        currentRowIndex = parseInt( $(this).closest('tr').find('td').eq(0).html() ) - 1

        let rowData = dataTable.row(currentRowIndex).data()

        departmentId = rowData[5]
    })

    $('#btn_confirm_delete_department').click(function(e) {
        e.preventDefault()
        if (flagDeleteMultiDepartment == true) {

            $.ajax({
                url: "http://localhost:8888/api/departments/delete-multiple",
                method: 'POST',
                contentType: 'application/json',
                dataType: 'json',
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem('token')
                },
                data: JSON.stringify(arrDepartmentId),
                success: function(response) {
                    $('#btn_no_department').click()//close modal

                    //Refresh table
                    dataTable.destroy()
                    getListDepartments('', '', '', '', PAGE_NUMBER, PAGE_SIZE, ORDER_BY)

                    //Reset arr accounts after delete
                    clearArrDepartmentId()
                },
                error: function(error) {
                    console.log(error)
                    //Reset arr accounts after delete
                    clearArrDepartmentId()

                    //Deselect all on the data table
                    dataTable.$('tr.selected').removeClass('selected');

                    if (error.status == 401) {
                        showErrorAuthentication(error.responseJSON.message)
                    }else if (error.status == 403) {
                        showErrorAuthentication("Forbidden!")
                    }else {
                        showErrorAuthentication("Unkown error")
                    }
                }
            })
        }else {
            $.ajax({
                url: 'http://localhost:8888/api/departments/delete/' + departmentId,
                method: 'POST',
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem('token')
                },
                success: function(response) {
                    $('#btn_no_department').click()
                    dataTable.row(currentRowIndex).remove().draw()
                },
                error: function(error) {
                    console.log(error)
                    if (error.status == 401) {
                        showErrorAuthentication(error.responseJSON.message)
                    }else if (error.status == 403) {
                        showErrorAuthentication("Forbidden!")
                    }else {
                        showErrorAuthentication("Unkown error")
                    }
                }
            })
        }
    })


}