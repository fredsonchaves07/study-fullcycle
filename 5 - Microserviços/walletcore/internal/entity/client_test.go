package entity

import (
	"testing"
)

func TestCreateNewClient(t *testing.T) {
	client, err := NewClient("John Doe", "j@j.com")
	if err != nil {
		t.Error("")
	}
}
