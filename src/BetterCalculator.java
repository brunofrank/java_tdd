public class BetterCalculator {
    private Boolean _isDirty;

    private String _operation;
    private float _state;
    private float _display;

    public float getDisplay(){
        return this._display;
    }

    public void enter(float number)
    {
        this._state = number;
        this._isDirty = true;
    }

    public void PressPlus()
    {
        this._operation = "+";
        if (this._isDirty) calculate();
    }

    public void pressEquals()
    {
        if (_isDirty) {
            this.calculate();
        }
    }

    void calculate()
    {
        switch (_operation)
        {
            case "+":
                this._display += this._state;
                break;
        }

        _isDirty = false;
    }
}
