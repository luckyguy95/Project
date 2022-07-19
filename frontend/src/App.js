import React, {useState, useEffect} from 'react';
import './App.css';
import Wrapper from './Wrapper';
import Hello from './Hello';


class App extends React.Component {

    constructor(props) {
        super(props);
    }

    componentDidMount() {

    }

    render() {
        return (
            <Wrapper>
                <Hello name="react" color="red"/>
                <Hello color="pink"/>
            </Wrapper>
        );
    }
}
export default App;

