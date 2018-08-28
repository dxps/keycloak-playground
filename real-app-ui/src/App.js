import React, {Component} from 'react';
import {BrowserRouter, Route, Link} from 'react-router-dom';
import Public from './Public';
import Protected from './Protected';
import './App.css';

class App extends Component {

    render() {

        return (
            <BrowserRouter>
                <div className="App">
                    <header className="App-header">
                        <h1 className="App-title">real-app-ui</h1>
                    </header>
                    <p className="App-intro">
                        <Link to="/">Public</Link> &nbsp; &nbsp; &nbsp;
                        <Link to="/protected">Protected</Link>
                    </p>
                    <Route exact path="/" component={Public} />
                    <Route path="/protected" component={Protected} />
                </div>
            </BrowserRouter>
        );

    }

}

export default App;
