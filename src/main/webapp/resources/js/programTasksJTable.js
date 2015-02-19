$(document).ready(function() {
    $('#programTasksTableContainer').jtable({
        title: 'Programs',
        defaultDateFormat: 'yy-mm-dd',
        selecting: true,
        sorting: true,
        multiSorting: true,
        actions: {
            listAction: 'tasks/getTasks',
            createAction: 'tasks/addTask',
            updateAction: 'tasks/updateTask',
            deleteAction: 'tasks/deleteTask'
        },
        fields: {
            id: {
                title: 'ID',
                list: false,
                key: true,
                create: false,
                edit: false,
                visibility: 'hidden'
            },
            program: {
                title: 'Program'
            },
            content: {
                title: 'Content',
                type: 'textarea'
            },
            taskday: {
            	title: 'Task day'
            },
            started: {
                title: 'Started on',
                type: 'date'
            },
            ended: {
                title: 'Ended on',
                type: 'date'
            },
            status: {
                title: 'Status',
                options: 'tasks/statuses'
            },
            comment: {
                title: 'Comments',
                type: 'textarea'
            },
            review: {
                title: 'Review',
                type: 'textarea'
            }
        },
        recordAdded: function(event, data){
            $('#programTasksTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            $('#programTasksTableContainer').jtable('load');
        }
    });
    $('#programTasksTableContainer').jtable('load');              
});