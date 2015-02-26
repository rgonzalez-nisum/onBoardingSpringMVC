$(document).ready(function() {
    $('#allProgramsTableContainer').jtable({
        title: 'Programs',
        defaultDateFormat: 'yy-mm-dd',
        selecting: true,
        sorting: true,
        multiSorting: true,
        openChildAsAccordion: true,
        actions: {
            listAction: 'programs/getAllPrograms',
            createAction: 'programs/addProgram',
            updateAction: 'programs/updateProgram',
            deleteAction: 'programs/deleteProgram'
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
            participant: {
                title: 'Participant',
                options: 'participants/getAllParticipantsAsOptions'
            },
            description: {
                title: 'Description',
                type: 'textarea'
            },
            status: {
                title: 'Status',
                options: 'statuses/getAllProgramStatusesAsOptions'
            },
            started: {
                title: 'Started on',
                type: 'date'
            },
            tasks: {
            	title: 'Tasks',
            	width: '2%',
            	sorting: false,
            	edit: false,
            	create: false,
            	display: function (program) {
                    var $img = $('<div class="jtable-tasks-icon" title="View tasks"/>');
                    $img.click(function () {
                        $('#allProgramsTableContainer').jtable('openChildTable',
                                $img.closest('tr'),
                                {
                                    title: program.record.description + ' - Tasks',
                                    actions: {
                                        listAction: function (postData, jtParams) {
                                            return {
                                                "Result": "OK",
                                                "Records": program.record.tasks
                                            };
                                        }
                                    },
                                    fields: {
                                        programId: {
                                            type: 'hidden',
                                            defaultValue: program.record.id
                                        },
                                        id: {
                                            key: true,
                                            create: false,
                                            edit: false,
                                            list: false
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
                                            type: 'date'
                                        },
                                        ended: {
                                            title: 'Ended on',
                                            type: 'date'
                                        },
                                        status: {
                                            title: 'Status',
                                            options: 'statuses/getAllTaskStatusesAsOptions'
                                        },
                                        comment: {
                                            title: 'Comments',
                                            type: 'textarea'
                                        },
                                        review: {
                                            title: 'Review',
                                            type: 'textarea'
                                        }, 
                                        task: {
                                        	width: '2%',
                                        	display: function (task) {
                                                var $img = $('<div class="jtable-programtasks-goto-icon" title="View task"/>');
                                                $img.click(function () {
                                                	$('<form action="program-tasks" method="POST">'
                                                			+ '<input type="hidden" name="programId" value="'+program.record.id+'">'
                                            		+ '</form>').submit();
                                                });
                                                return $img;
                                        	}
                                        }
                                    }
                                }, function (data) {
                                    data.childTable.jtable('load');
                                });
                    });
                    return $img;
            	}
            }
        },
        formCreated: function (event, data) {
            data.form.find('input[name="participant"]').addClass('validate[required]');
            data.form.find('input[name="description"]').addClass('validate[required]');
            data.form.find('input[name="status"]').addClass('validate[required');
            data.form.find('input[name="started"]').addClass('validate[required,custom[date]]');
            data.form.validationEngine();
        },
        formSubmitting: function (event, data) {
            return data.form.validationEngine('validate');
        },
        formClosed: function (event, data) {
            data.form.validationEngine('hide');
            data.form.validationEngine('detach');
        },
        recordAdded: function(event, data){
            $('#allProgramsTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            $('#allProgramsTableContainer').jtable('load');
        }
    });
    $('#allProgramsTableContainer').jtable('load');              
});