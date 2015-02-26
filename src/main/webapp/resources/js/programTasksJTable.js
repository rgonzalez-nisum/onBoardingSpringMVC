$(document).ready(function() {
	var participantId;
	
    $('#programTasksTableContainer').jtable({
        title: 'Programs',
        defaultDateFormat: 'yy-mm-dd',
        selecting: true,
        sorting: true,
        multiSorting: true,
        actions: {
            listAction: function (postData, jtParams) {
            	participantId = postData.participantId;
            	
            	return $.Deferred(function ($dfd) {
                    $.ajax({
                        url: 'tasks/getTaskByProgramId',
                        type: 'POST',
                        dataType: 'json',
                        data: postData,
                        success: function (data) {
                            $dfd.resolve(data);
                        },
                        error: function () {
                            $dfd.reject();
                        }
                    });
                });
        	},
            createAction: 'tasks/addTask',
            updateAction: 'tasks/updateTask',
            deleteAction: 'tasks/deleteTask'
        },
        fields: {
            id: {
                title: 'ID',
                key: true,
                list: false,
                create: false,
                edit: false,
                visibility: 'hidden'
            },
            program: {
                title: 'Program',
            	options: function(data) {
            		return 'programs/getProgramByParticipantIdAsOptions?participantId=' + participantId;
                },
        		list: false,
                visibility: 'hidden'
            },
            content: {
                title: 'Content',
                type: 'textarea'
            },
            taskDay: {
            	title: 'Task day'
            },
            started: {
                title: 'Started on',
                type: 'date',
            	create: false
            },
            ended: {
                title: 'Ended on',
                type: 'date',
            	create: false
            },
            status: {
                title: 'Status',
                options: 'statuses/getAllTaskStatusesAsOptions'
            },
            comment: {
                title: 'Comments',
                type: 'textarea',
            	create: false
            },
            review: {
                title: 'Review',
                type: 'textarea',
            	create: false
            }
        },
        formCreated: function (event, data) {
            data.form.find('input[name="program"]').addClass('validate[required]');
            data.form.find('input[name="content"]').addClass('validate[required]');
            data.form.find('input[name="taskDay"]').addClass('validate[required');
            data.form.find('input[name="started"]').addClass('validate[custom[date]]');
            data.form.find('input[name="ended"]').addClass('validate[custom[date],future[started]]');
            data.form.find('input[name="status"]').addClass('validate[required]');
            data.form.validationEngine();
            
            $('.jtable-input.jtable-date-input').parent().css({
            	'float':'left',
            	'min-width':'0',
            	'width':'50%'
    		});
        },
        formSubmitting: function (event, data) {
            return data.form.validationEngine('validate');
        },
        formClosed: function (event, data) {
            data.form.validationEngine('hide');
            data.form.validationEngine('detach');
        },
        recordAdded: function(event, data){
            $('#programTasksTableContainer').jtable('reload');
        },
        recordUpdated: function(event, data){
            $('#programTasksTableContainer').jtable('reload');
        }
    });
});