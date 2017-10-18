var events = (function() {
    var events = {};
    return {
        on: function (eventName, fn) {
            events[eventName] = events[eventName] || [];
            events[eventName].push(fn);
        },
        off: function(eventName, fn) {
            if (events[eventName]) {
                for (var i = 0; i < events[eventName].length; i++) {
                    if( events[eventName][i] === fn ) {
                        events[eventName].splice(i, 1);
                        break;
                    }
                }
            }
        },
        emit: function(eventName, data) {
            if (events[eventName]) {
                events[eventName].forEach(function(fn) {
                    fn(data);
                });
            }
        }
    };
})();